package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.BoughtItemList;
import utility.Connector;

public class MySQLBoughtItemListDao implements BoughtItemListDao{

	public List getAllOrderInfo(String userid){
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList orderinfo=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql="SELECT i.main_image_path, i.item_name, i.item_id, os.purchase_date FROM orders AS os " +
        				"INNER JOIN order_detail AS od ON os.order_id = od.order_id " +
        				"INNER JOIN item AS i ON od.item_id=i.item_id " +
        				"WHERE i.item_id IN (SELECT item_id FROM order_detail WHERE order_id IN (SELECT order_id FROM orders WHERE user_id='"+userid+"')) " +
        				"AND os.order_id IN (SELECT order_id FROM orders WHERE user_id='"+userid+"');";
        	//sSystem.out.println(sql);


            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
            	BoughtItemList b=new BoughtItemList();

                b.setItemImagePath(rs.getString(1)); //Beanに合わせてitemimagepathにしている(データベースではmain_image_path)
                b.setItemName(rs.getString(2));
                b.setItemId(rs.getInt(3)); //
                b.setPurchaseDate(rs.getString(4));

                orderinfo.add(b);
            }

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
            System.out.println(e.getMessage());
        }finally{
            try{
                if(rs !=null){
                    rs.close();
                }
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }finally{
            	if(cn !=null){
                    Connector.getInstance().closeConnection();
                }
            }
        }
		return orderinfo;
	}
}
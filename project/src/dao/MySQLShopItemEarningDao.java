package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ShopItemEarning;
import utility.Connector;

public class MySQLShopItemEarningDao implements ShopItemEarningDao{
	public List getShopItemEarning(String shopId) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List shopitemearning =new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql= "select item_name,count(od.item_id),count(od.item_id)*i.item_price " +
            			"from order_detail od " +
            			"INNER JOIN item i ON od.item_id=i.item_id " +
            			"INNER JOIN shop s ON i.shop_id=s.shop_id " +
            			"where i.shop_id='"+shopId+"' " +
            			"group by od.item_id;";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                ShopItemEarning s=new ShopItemEarning();

                s.setItemName(rs.getString(1));
                s.setCount(rs.getInt(2));
                s.setEarning(rs.getInt(3));

                shopitemearning.add(s);
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
        return shopitemearning;
	}
}

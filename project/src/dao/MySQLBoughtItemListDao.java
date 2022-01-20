package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.UserOrderItemDetails;
import utility.Connector;

public class MySQLBoughtItemListDao{

	public List getAllOrderInfo(String itemid,String userid){
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList orderinfo=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql= "";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                UserOrderItemDetails u=new UserOrderItemDetails();

                u.setPurchaseDate(rs.getString(1));
                u.setOrderId(rs.getInt(2));
                u.setTotalPayment(rs.getInt(3));
                u.setBoostAmount(rs.getInt(4));
                u.setShopName(rs.getString(5));
                u.setShopId(rs.getString(6));
                u.setItemImagePath(rs.getString(7));
                u.setItemId(rs.getString(8));
                u.setItemName(rs.getString(9));
                u.setItemPrice(rs.getInt(10));
                u.setItemDataPath(rs.getString(11));

                orderinfo.add(u);
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
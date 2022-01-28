package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;




import bean.UserOrderItemDetails;
import utility.Connector;

public class MySQLUserOrderItemDetailsDao implements UserOrderItemDetailsDao{

	public UserOrderItemDetails getOrderInfo(String itemid,String userid){
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        UserOrderItemDetails orderInfo=null;
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql= "SELECT os.purchase_date, od.order_id, os.total_payment, os.boost_amount, s.shop_name, s.shop_id, i.main_image_path, od.item_id, i.item_name, i.item_price, i.item_data_path \r\n" +
        			"FROM orders AS os \r\n" +
        			"INNER JOIN order_detail AS od ON os.order_id=od.order_id \r\n" +
        			"INNER JOIN item AS i ON od.item_id=i.item_id \r\n" +
        			"INNER JOIN shop AS s ON i.shop_id=s.shop_id \r\n" +
        			"WHERE os.order_id=(SELECT order_id FROM order_detail WHERE item_id=(SELECT item_id FROM order_detail WHERE item_id='1' AND order_id IN (SELECT order_id FROM orders WHERE user_id='U1')));";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            	orderInfo =new UserOrderItemDetails();
            	   rs.next();

                orderInfo.setPurchaseDate(rs.getString(1));
                orderInfo.setOrderId(rs.getInt(2));
                orderInfo.setTotalPayment(rs.getInt(3));
                orderInfo.setBoostAmount(rs.getInt(4));
                orderInfo.setShopName(rs.getString(5));
                orderInfo.setShopId(rs.getString(6));
                orderInfo.setItemImagePath(rs.getString(7));
                orderInfo.setItemId(rs.getString(8));
                orderInfo.setItemName(rs.getString(9));
                orderInfo.setItemPrice(rs.getInt(10));
                orderInfo.setItemDataPath(rs.getString(11));




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
		return orderInfo;
	}
}
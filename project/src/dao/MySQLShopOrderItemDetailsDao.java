package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ShopOrderItemDetails;
import utility.Connector;

public class MySQLShopOrderItemDetailsDao implements ShopOrderItemDetailsDao{
	public List getShopOrderDetails(String orderid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Orders=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	int oid=Integer.parseInt(orderid);
        	//商品が削除されている場合も表示する
            String sql="SELECT o.order_id, o.purchase_date, u.user_name, u.user_id, i.item_name, i.item_id, i.main_image_path, i.item_price FROM orders o LEFT OUTER JOIN user u ON o.user_id=u.user_id LEFT OUTER JOIN order_detail od ON o.order_id=od.order_id LEFT OUTER JOIN item i ON od.item_id=i.item_id WHERE o.order_id="+oid;

            st=cn.prepareStatement(sql);

            while(rs.next()){
	            rs=st.executeQuery();
	            ShopOrderItemDetails o=new ShopOrderItemDetails();

	            o.setOrderId(rs.getInt(1));
	            o.setPurchaseDate(rs.getString(2));
	            o.setUserName(rs.getString(3));
	            o.setUserId(rs.getString(4));
	            o.setItemName(rs.getString(5));
	            o.setItemId(rs.getInt(6));
	            o.setMainImagePath(rs.getString(7));
	            o.setItemPrice(rs.getInt(8));

	            Orders.add(o);
            }

            /*
			SELECT o.order_id, o.purchase_date, u.user_name, u.user_id, i.item_name, i.item_id, i.main_image_path, i.item_price FROM orders o LEFT OUTER JOIN user u ON o.user_id=u.user_id LEFT OUTER JOIN order_detail od ON o.order_id=od.order_id LEFT OUTER JOIN item i ON od.item_id=i.item_id WHERE o.order_id=
            */

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
        return Orders;
	}
}

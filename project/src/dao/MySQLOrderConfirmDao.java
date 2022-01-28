package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OrderConfirm;
import utility.Connector;

public class MySQLOrderConfirmDao implements OrderConfirmDao {

	@Override
	public List confirmOrder(String userid, String shopid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList OC=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql="SELECT u.user_point, s.shop_name, s.shop_id, i.item_name, i.item_id, i.main_image_path, i.item_price, " +
        				"(SELECT SUM(its.item_price) FROM item its LEFT OUTER JOIN cart cs ON its.item_id=cs.item_id LEFT OUTER JOIN user us ON cs.user_id=us.user_id WHERE u.user_id=us.user_id AND s.shop_id=its.shop_id GROUP BY us.user_id) as itemprice, " +
        				"(SELECT COUNT(its.item_id) FROM item its LEFT OUTER JOIN cart cs ON its.item_id=cs.item_id LEFT OUTER JOIN user us ON cs.user_id=us.user_id WHERE u.user_id=us.user_id AND s.shop_id=its.shop_id GROUP BY us.user_id) as itemcount " +
        				"FROM cart c " +
        				"LEFT OUTER JOIN item i ON c.item_id=i.item_id " +
        				"LEFT OUTER JOIN user u ON c.user_id=u.user_id " +
        				"LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id " +
        				"WHERE u.user_id='"+userid+"' AND i.item_is_open=1 AND i.unused=1 AND s.shop_is_open=1 AND s.unused=1 AND s.shop_id='"+shopid+"';";


            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
            	OrderConfirm o=new OrderConfirm();

                o.setUserPoint(rs.getInt(1));
                o.setShopName(rs.getString(2));
                o.setShopId(rs.getString(3));
                o.setItemName(rs.getString(4));
                o.setItemId(rs.getString(5));
                o.setMainImagePath(rs.getString(6));
                o.setTotalPayment(rs.getInt(7));
                o.setOrderPrice(rs.getInt(8));
                o.setOrderCount(rs.getInt(9));
                o.setBoostAmount(0);			//この表示の後ににboost金額を表示するので0を返す

                /*
				SELECT u.user_point, s.shop_name, s.shop_id, i.item_name, i.item_id, i.main_image_path, i.item_price, (SELECT SUM(its.item_price) FROM item its LEFT OUTER JOIN cart cs ON its.item_id=cs.item_id LEFT OUTER JOIN user us ON cs.user_id=us.user_id WHERE u.user_id=us.user_id GROUP BY us.user_id) as itemprice, (SELECT COUNT(its.item_id) FROM item its LEFT OUTER JOIN cart cs ON its.item_id=cs.item_id LEFT OUTER JOIN user us ON cs.user_id=us.user_id WHERE u.user_id=us.user_id GROUP BY us.user_id) as itemcount FROM cart c LEFT OUTER JOIN item i ON c.item_id=i.item_id LEFT OUTER JOIN user u ON c.user_id=u.user_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id WHERE u.user_id=1 AND i.item_is_open=1 AND i.unused=1 AND s.shop_is_open=1 AND s.unused=1
                */

                OC.add(o);
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
		return OC;
	}

}

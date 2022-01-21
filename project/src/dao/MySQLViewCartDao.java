package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ViewCart;
import utility.Connector;

public class MySQLViewCartDao implements ViewCartDao {

	@Override
	public List getCartItem(String userid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Cart=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT s.shop_name, s.shop_id, i.item_name, i.item_id, i.main_image_path, i.item_price, (SELECT SUM(its.item_price) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id),(SELECT COUNT(its.item_id) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) FROM cart c LEFT OUTER JOIN item i ON c.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id WHERE c.user_id='"+userid+"' AND i.item_is_open=1 AND i.unused=1 AND s.shop_is_open=1 AND s.unused=1";

            st=cn.prepareStatement(sql);

            while(rs.next()){
	            rs=st.executeQuery();
	            ViewCart v=new ViewCart();

	            v.setShopName(rs.getString(1));
	            v.setShopId(rs.getString(2));
	            v.setItemName(rs.getString(3));
	            v.setItemId(rs.getString(4));		//beanをStringで作ってたみたいなのでとりあえずString
	            v.setMainImagePath(rs.getString(5));
	            v.setItemPrice(rs.getInt(6));
	            v.setOrderPrice(rs.getInt(7));
	            v.setOrderCount(rs.getInt(8));

	            Cart.add(v);
            }

            /*
            SELECT s.shop_name, s.shop_id, i.item_name, i.main_image_path, i.item_price, (SELECT SUM(its.item_price) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) as oprice,(SELECT COUNT(its.item_id) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) as scount FROM cart c LEFT OUTER JOIN item i ON c.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id
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
        return Cart;
	}

	public ViewCart getOneCartItem(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        ViewCart v=new ViewCart();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT s.shop_name, s.shop_id, i.item_name, i.item_id, i.main_image_path, i.item_price, (SELECT SUM(its.item_price) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id),(SELECT COUNT(its.item_id) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) FROM cart c LEFT OUTER JOIN item i ON c.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id WHERE c.user_id='"+userid+"' AND i.item_id="+itemid+" AND i.item_is_open=1 AND i.unused=1 AND s.shop_is_open=1 AND s.unused=1";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
	            v.setShopName(rs.getString(1));
	            v.setShopId(rs.getString(2));
	            v.setItemName(rs.getString(3));
	            v.setItemId(rs.getString(4));		//beanをStringで作ってたみたいなのでとりあえずString
	            v.setMainImagePath(rs.getString(5));
	            v.setItemPrice(rs.getInt(6));
	            v.setOrderPrice(rs.getInt(7));
	            v.setOrderCount(rs.getInt(8));
            }

            /*
            SELECT s.shop_name, s.shop_id, i.item_name, i.main_image_path, i.item_price, (SELECT SUM(its.item_price) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) as oprice,(SELECT COUNT(its.item_id) FROM cart cs LEFT OUTER JOIN item its ON cs.item_id=its.item_id LEFT OUTER JOIN shop ss ON its.shop_id=ss.shop_id WHERE i.shop_id=ss.shop_id AND c.user_id=cs.user_id GROUP BY ss.shop_id, cs.user_id) as scount FROM cart c LEFT OUTER JOIN item i ON c.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id
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
        return v;
	}

}

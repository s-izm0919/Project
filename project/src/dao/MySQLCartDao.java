package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Cart;
import bean.Shop;
import utility.Connector;

public class MySQLCartDao implements CartDao {

	@Override
	public void addCart(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();
            //

            String sql="insert into cart(user_id,item_id)" + " values(?,?) ";

            st=cn.prepareStatement(sql);

            st.setString(1, userid);
            int i_id=Integer.parseInt(itemid);
            st.setInt(2, i_id);

            st.executeUpdate();

            //System.out.println("正常にカートにコミットできた");

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
        }
        finally{
            try{
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
	}

	//既に商品がカートにあるか調べる
	public Cart checkCart(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        Cart c = null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select user_id, item_id, addcart_date from cart where user_id='"+userid+"' AND item_id='"+itemid+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            c=new Cart();

            rs.next();

            c.setUserId(rs.getString(1));
            c.setItemId(rs.getInt(2));
            c.setAddcartDate(rs.getString(3));

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
        return c;
	}
	public List getShopId(String userid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList list = new ArrayList();

        Shop s = null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT DISTINCT i.shop_id, s.shop_name FROM item i LEFT OUTER JOIN cart c ON i.item_id=c.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id WHERE c.user_id = '"+userid+"' and i.unused = 1";

            System.out.println(sql);

            //System.out.println(sql);
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()) {

            	s=new Shop();

            	s.setShopId(rs.getString(1));
            	s.setShopName(rs.getString(2));
            	System.out.println(s.getShopName());

            	list.add(s);

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
        return list;
	}
	//ショップが商品を非公開または削除したとき
	public void removeItemShop(String itemid) {
			Connection cn=null;
	        PreparedStatement st=null;

	        try{
	        	cn = Connector.getInstance().beginTransaction();
	            //コマンド持ってくるからnullはないはずだけど一応

	        	if(itemid!=null) {
	        		String sql="DELETE FROM cart WHERE item_id=?";


		            st=cn.prepareStatement(sql);

		            st.setString(1, itemid);
		            st.executeUpdate();
	        	}
		        Connector.getInstance().commit();

	        }catch(SQLException e){
	            Connector.getInstance().rollback();
	        }
	        finally{
	            try{
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
	}
	//ユーザーが商品をカートから削除
	public void removeCartItem(String userid,String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();
            //コマンド持ってくるからnullはないはずだけど一応

        	if(itemid!=null && userid!=null) {
        		String sql="DELETE FROM cart WHERE item_id=? AND user_id=?";


	            st=cn.prepareStatement(sql);

	            st.setString(1, itemid);
	            st.setString(2, userid);
	            st.executeUpdate();
        	}
	        Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
        }
        finally{
            try{
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
	}
	//ユーザーがカートからショップごと削除
	public void removeCartItemShop(String userid,String shopid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();
            //コマンド持ってくるからnullはないはずだけど一応

        	if(shopid!=null && userid!=null) {
        		String sql="DELETE FROM cart WHERE item_id IN (SELECT item.item_id FROM item WHERE item.shop_id=?) AND user_id=?";


	            st=cn.prepareStatement(sql);

	            st.setString(1, shopid);
	            st.setString(2, userid);
	            st.executeUpdate();
        	}
	        Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
        }
        finally{
            try{
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
	}

}

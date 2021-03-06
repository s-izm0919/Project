package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Shop;
import utility.Connector;

public class MySQLShopDao implements ShopDao {

	public void addShop(Shop shopInfo) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

           // String sql="insert into shop(shop_id,user_id,shop_name,shop_explanation,shop_earning,shop_is_open,shop_sellerword)" + " values(?,?,?,?,?,?,?) ";

            String sql="insert into shop(user_id,shop_name,shop_explanation,shop_earning,shop_is_open,shop_sellerword)" + " values(?,?,?,?,?,?) ";


            st=cn.prepareStatement(sql);


            st.setString(1, shopInfo.getUserId());
            st.setString(2, shopInfo.getShopName());
            st.setString(3, shopInfo.getShopExplanation());
            st.setInt(4, 0);	//notnull制約のため
            					//nullでなければ問題ないので
            					//commandでsetterを使っている場合は消してください
           st.setInt(5, shopInfo.getShopIsOpen());
            st.setString(6, shopInfo.getShopSellerword());

            st.executeUpdate();

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
        }finally{
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

	public Shop getUserShopInfo(String userId) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        Shop s = null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select * from shop where user_id='"+userId+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            //s=new Shop();

           while( rs.next()) {
        	   s=new Shop();
            s.setShopId(rs.getString(1));
            s.setUserId(rs.getString(2));
            s.setShopName(rs.getString(3));
            s.setShopExplanation(rs.getString(4));
            s.setShopEarning(rs.getInt(5));
            s.setShopIsOpen(rs.getInt(6));
            s.setShopSellerword(rs.getString(7));
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
        return s;
	}


	public Shop getShopInfo(String shopId) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        Shop s = null;
        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select * from shop where shop_id='"+shopId+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            //s=new Shop();

           while( rs.next()) {
        	   s=new Shop();
            s.setShopId(rs.getString(1));
            s.setUserId(rs.getString(2));
            s.setShopName(rs.getString(3));
            s.setShopExplanation(rs.getString(4));
            s.setShopEarning(rs.getInt(5));
            s.setShopIsOpen(rs.getInt(6));
            s.setShopSellerword(rs.getString(7));
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
        return s;
	}




	public void updateShop(Shop shopInfo) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();


            //データに変更がない項目は取ってきたデータをcommand内で再びsetすること
            //(setしないとnullで上書きされるため)
            String sql="update shop set shop_name=?, shop_explanation=?, shop_sellerword=?, shop_is_open=? where shop_id=?";
            st=cn.prepareStatement(sql);


            st=cn.prepareStatement(sql);

            st.setString(1, shopInfo.getShopName());

            st.setString(2, shopInfo.getShopExplanation());

            st.setString(3, shopInfo.getShopSellerword());

            st.setInt(4, shopInfo.getShopIsOpen());

            st.setString(5, shopInfo.getShopId());

            st.executeUpdate();

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
            System.out.println(e.getMessage());
        }finally{
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
	public List getShopNamesSearchItem(String searchWord) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Shop=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            //shop表とitem表を内部結合し並び替えている
            if(searchWord==null) {	//検索文字がnullのとき全部検索する
            	sql="select shop.shop_id, shop_name from shop inner join item using (shop_id) where item_is_open=1 AND shop_is_open=1 order by item_register_date DESC";
            }else {
            	sql="select shop.shop_id, shop_name from shop inner join item using (shop_id) where item_is_open=1 AND shop_is_open=1 AND item_name like '%"+searchWord+"%' order by item_register_date DESC";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Shop s=new Shop();

                s.setShopId(rs.getString(1));
                s.setShopName(rs.getString(2));

                Shop.add(s);
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
        return Shop;

	}
    public List getShopNamesSearchShop(String searchWord) {

    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Shop=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            //shop表とitem表を内部結合し並び替えている
            if(searchWord==null) {	//検索文字がnullのとき全部検索する
            	sql="select shop.shop_id, shop_name from shop inner join item using (shop_id) where item_is_open=1 AND shop_is_open=1 order by item_register_date DESC";
            }else {
            	sql="select shop.shop_id, shop_name from shop inner join item using (shop_id) where item_is_open=1 AND shop_is_open=1 AND shop_name like '%"+searchWord+"%' order by item_register_date DESC";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Shop s=new Shop();

                s.setShopId(rs.getString(1));
                s.setShopName(rs.getString(2));

                Shop.add(s);
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
        return Shop;
    }

    public int getShopEarning(String shopId) {
    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        int total_earning = 0;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select count(od.item_id)*i.item_price " +
            			"from order_detail od " +
            			"INNER JOIN item i ON od.item_id=i.item_id " +
            			"INNER JOIN shop s ON i.shop_id=s.shop_id " +
            			"where od.order_id IN (select order_id from orders where purchase_date > (NOW() - INTERVAL 1 MONTH)) AND i.shop_id='"+shopId+"' " +
	            		"group by od.item_id;";
            System.out.println(sql);

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

           while( rs.next()) {
        	   total_earning += rs.getInt(1);
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
        return total_earning;
    }



public boolean checkUserId(String userId) {
	Connection cn = null;
	PreparedStatement st = null;
	ResultSet rs = null;

	boolean f = true;
	try {
		cn = Connector.getInstance().beginTransaction();

		cn.setAutoCommit(false);

		String sql = "select * from shop where user_id ='" + userId + "'";

		st = cn.prepareStatement(sql);

		rs = st.executeQuery();
		while (rs.next()) {
			f = false;

		}
		Connector.getInstance().commit();
	} catch (SQLException e) {
		Connector.getInstance().rollback();
		System.out.println(e.getMessage());
	} finally {
		try {
			if (rs != null) {
				rs.close();
			}
			if (st != null) {
				st.close();
			}
		} catch (SQLException e2) {
			System.out.println(e2.getMessage());
		} finally {
			if (cn != null) {
				Connector.getInstance().closeConnection();
			}
		}
	}
	return f;
}




}

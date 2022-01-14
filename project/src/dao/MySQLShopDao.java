package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Shop;

public class MySQLShopDao implements ShopDao {

	public void addShop(Shop shopInfo) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //

           // String sql="insert into shop(shop_id,user_id,shop_name,shop_explanation,shop_earning,shop_is_open,shop_sellerword)" + " values(?,?,?,?,?,?,?) ";

            String sql="insert into shop(user_id,shop_name,shop_explanation,shop_earning,shop_is_open,shop_sellerword)" + " values(?,?,?,?,?,?) ";


            st=cn.prepareStatement(sql);


            st.setString(1, shopInfo.getUserId());
            st.setString(2, shopInfo.getShopName());
            st.setString(3, shopInfo.getShopExplanation());
            st.setInt(4, 0);	//notnull制約のため
            					//nullでなければ問題ないので
            					//commandでsetterを使っている場合は消してください
           st.setInt(5, 1);
            st.setString(6, shopInfo.getShopSellerword());

            st.executeUpdate();

            cn.commit();


        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());

        }catch(SQLException e){
            try{
                cn.rollback();

            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            System.out.println(e.getMessage());

            }
        }
        finally{
            try{
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());

            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
	}

	public Shop getShopInfo(String shopId) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        Shop s = null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select * from shop where shop_id='"+shopId+"'";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            s=new Shop();

            rs.next();

            s.setShopId(rs.getString(1));
            s.setUserId(rs.getString(2));
            s.setShopName(rs.getString(3));
            s.setShopExplanation(rs.getString(4));
            s.setShopEarning(rs.getInt(5));
            s.setShopIsOpen(rs.getInt(6));
            s.setShopSellerword(rs.getString(7));


            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return s;
	}

	public void updateShop(Shop shopInfo) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            //データに変更がない項目は取ってきたデータをcommand内で再びsetすること
            //(setしないとnullで上書きされるため)
            String sql="update shop set shop_name=?, shop_explanation=?, shop_sellerword=?, shop_is_open=? where shop_id=?";

            st.setString(1, shopInfo.getShopName());
            st.setString(2, shopInfo.getShopExplanation());
            st.setString(3, shopInfo.getShopSellerword());
            st.setInt(4, shopInfo.getShopIsOpen());
            st.setString(5, shopInfo.getUserId());

            st=cn.prepareStatement(sql);

            st.executeUpdate();

            cn.commit();


        }catch (ClassNotFoundException e){
        	System.out.println(e.getMessage());

        }catch(SQLException e){
            try{
                cn.rollback();

            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            System.out.println(e.getMessage());

            }
        }
        finally{
            try{
                if(st !=null){
                    st.close();
                }
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());

            }finally{
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
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
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
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
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
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
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
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
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return Shop;
    }
}

package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Favorite;

public class MySQLFavoriteDao implements FavoriteDao{
	public List getSearchItemFavoriteCount(String itemName) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        ArrayList favoriteCount=new ArrayList();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select item_id,COUNT(*) from favorite where item_id IN (select item_id from item where item_name like '%"+itemName+"%'AND item_is_open=1)";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                Favorite f =new Favorite();

                f.setUserId(rs.getString(1));
                f.setFavoriteCount(rs.getInt(2));

                favoriteCount.add(f);
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
        return favoriteCount;
	}
	public List getSearchShopFavoriteCount(String shopName) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;
        ArrayList favoriteCount=new ArrayList();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="select item_id,COUNT(*) from favorite where item_id IN (select item_id from item where item_is_open=1 AND shop_id IN (select shop_id from shop where shop_name like '%"+shopName+"% AND shop_is_open=1))";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                Favorite f =new Favorite();

                f.setUserId(rs.getString(1));
                f.setFavoriteCount(rs.getInt(2));

                favoriteCount.add(f);
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
        return favoriteCount;
	}
}

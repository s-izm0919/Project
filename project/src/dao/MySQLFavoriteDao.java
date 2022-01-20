package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Favorite;
import utility.Connector;

public class MySQLFavoriteDao implements FavoriteDao{
	public List getSearchItemFavoriteCount(String itemName) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList favoriteCount=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select item_id,COUNT(*) from favorite where item_id IN (select item_id from item where item_name like '%"+itemName+"%'AND item_is_open=1)";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                Favorite f =new Favorite();

                f.setUserId(rs.getString(1));
                f.setFavoriteCount(rs.getInt(2));

                favoriteCount.add(f);
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
        return favoriteCount;
	}
	public List getSearchShopFavoriteCount(String shopName) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList favoriteCount=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select item_id,COUNT(*) from favorite where item_id IN (select item_id from item where item_is_open=1 AND shop_id IN (select shop_id from shop where shop_name like '%"+shopName+"% AND shop_is_open=1))";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                Favorite f =new Favorite();

                f.setUserId(rs.getString(1));
                f.setFavoriteCount(rs.getInt(2));

                favoriteCount.add(f);
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
        return favoriteCount;
	}
}

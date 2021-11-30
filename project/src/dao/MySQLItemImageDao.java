package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ItemImage;

public class MySQLItemImageDao implements ItemImageDao {

	@Override
	public void addItemImage(ItemImage itemimage) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            //

            String sql="insert into item_image(image_id, sub_image_path, item_id)" + " values(?,?,?) ";

            st=cn.prepareStatement(sql);

            st.setInt(1, itemimage.getImageId());
            st.setString(2, itemimage.getSubImagePath());
            st.setInt(3, itemimage.getItemId());

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
	public void removeItemImage(int itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="delete from item_image where item_id="+itemid;

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
}

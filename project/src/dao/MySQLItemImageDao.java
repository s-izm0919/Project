package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import bean.ItemImage;
import utility.Connector;

public class MySQLItemImageDao implements ItemImageDao {

	@Override
	public void addItemImage(ItemImage itemimage) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="insert into item_image(image_id, sub_image_path, item_id)" + " values(?,?,?) ";

            st=cn.prepareStatement(sql);

            st.setInt(1, itemimage.getImageId());
            st.setString(2, itemimage.getSubImagePath());
            st.setInt(3, itemimage.getItemId());

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
	public void removeItemImage(int itemid) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="delete from item_image where item_id="+itemid;

            st=cn.prepareStatement(sql);
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
}

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ItemEdit;
import utility.Connector;

public class MySQLItemEditDao implements ItemEditDao {

	@Override
	public ItemEdit getItemDetails(int itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ItemEdit i = null;
        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT i.item_name, i.item_price, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ) as subimage, i.item_explanation, c.category_name, c.category_id, i.item_data_path, i.item_is_open FROM item i LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE i.unused=1 AND i.item_id='"+itemid+"'GROUP BY item_id ORDER BY item_register_date DESC";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            i=new ItemEdit();

            rs.next();

            i.setItemName(rs.getString(1));
            i.setItemPrice(rs.getInt(2));
            i.setItemId(rs.getInt(3));
            i.setMainImagePath(rs.getString(4));
            i.setSubImagePath(rs.getString(5));
            i.setItemExplanation(rs.getString(6));
            i.setCategoryName(rs.getString(7));
            i.setCategoryId(rs.getInt(8));
            i.setItemDataPath(rs.getString(9));
            i.setItemIsOpen(rs.getInt(10));
            /*
			SELECT i.item_name, i.item_price, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ) as subimage, i.item_explanation, c.category_name, c.category_id, i.item_data_path, i.item_is_open FROM item i LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE i.unused=1 AND i.shop_id='%'GROUP BY item_id ORDER BY item_register_date DESC
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
        return i;
	}

}

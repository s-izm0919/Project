package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.ItemDetails;
import utility.Connector;

public class MySQLItemDetailsDao implements ItemDetailsDao {

	@Override
	public ItemDetails getItemDetails(String itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ItemDetails id=null;
        try{
        	cn = Connector.getInstance().beginTransaction();
        	//商品が削除されている場合も表示する
        	int i_id=Integer.parseInt(itemid);
            String sql=" SELECT i.item_name, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ) as subimage, i.item_explanation, i.item_price, s.shop_name, s.shop_id, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as favorite, c.category_name, c.category_id FROM item i LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE i.item_id="+i_id+" AND i.item_is_open=1 AND i.unused=1 AND s.shop_is_open=1 AND s.unused=1";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
	            id=new ItemDetails();

	            id.setItemName(rs.getString(1));
	            id.setItemId(rs.getInt(2));
	            id.setMainImagePath(rs.getString(3));
	            id.setSubImagePath(rs.getString(4));
	            id.setItemExplanation(rs.getString(5));
	            id.setItemPrice(rs.getInt(6));
	            id.setShopName(rs.getString(7));
	            id.setShopId(rs.getString(8));
	            id.setFavoriteCount(rs.getInt(9));
	            id.setCategoryName(rs.getString(10));
				id.setCategoryId(rs.getInt(11));

            }

            /*
            SELECT i.item_name, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ) as subimage, i.item_explanation, i.item_price, s.shop_name, s.shop_id, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as favorite, c.category_name, c.category_id FROM item i LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE i.item_id=1
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
        return id;
	}

}

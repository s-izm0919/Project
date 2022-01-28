package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ItemSearch;
import utility.Connector;

public class MySQLNewItemDao implements NewItemDao {

	@Override
	public List getShopNewItems(String shopid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_id='"+shopid+"' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC limit 5";
        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC limit 5
        	*/

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                ItemSearch i=new ItemSearch();

                i.setMainImagePath(rs.getString(1));
                i.setCategoryId(rs.getInt(2));
                i.setItemName(rs.getString(3));
                i.setItemId(rs.getInt(4));
                i.setShopId(rs.getString(5));
                i.setItemPrice(rs.getInt(6));
                i.setCategoryName(rs.getString(7));
                i.setShopName(rs.getString(8));
                i.setFavoriteCount(rs.getInt(9));

                Items.add(i);
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
		return Items;
	}

}

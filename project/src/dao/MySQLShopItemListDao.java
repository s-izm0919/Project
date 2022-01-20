package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ShopItemList;
import utility.Connector;

public class MySQLShopItemListDao implements ShopItemListDao {

	@Override
	public List getItemList(String shopid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;

        	sql="SELECT i.item_name, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ), i.item_is_open, i.item_price, (SELECT COUNT(od.item_id) FROM order_detail od WHERE od.item_id=i.item_id), i.item_price*(SELECT COUNT(od.item_id) FROM order_detail od WHERE od.item_id=i.item_id), c.category_name, c.category_id, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE shop_id='"+shopid+"' AND i.unused=1 GROUP BY item_id";


            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
            	ShopItemList i=new ShopItemList();

                i.setItemName(rs.getString(1));
                i.setItemId(rs.getInt(2));
                i.setMainImagePath(rs.getString(3));
                i.setSubImagePath(rs.getString(4));
                i.setItemIsOpen(rs.getInt(5));
                i.setItemPrice(rs.getInt(6));
                i.setSoldCount(rs.getInt(7));
                i.setSoldPrice(rs.getInt(8));
                i.setCategoryName(rs.getString(9));
                i.setCategoryId(rs.getInt(10));
                i.setFavoriteCount(rs.getInt(11));


                /*
				SELECT i.item_name, i.item_id, i.main_image_path, (SELECT GROUP_CONCAT(ii.sub_image_path ORDER BY ii.image_id) FROM item_image ii WHERE i.item_id=ii.item_id ) as subimage, i.item_is_open, i.item_price, (SELECT COUNT(od.item_id) FROM order_detail od WHERE od.item_id=i.item_id) as soldcount, i.item_price*(SELECT COUNT(od.item_id) FROM order_detail od WHERE od.item_id=i.item_id) as soldprice, c.category_name, c.category_id, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as fcount FROM item i LEFT OUTER JOIN category c ON i.category_id=c.category_id WHERE shop_id='%' AND i.unused=1 GROUP BY item_id
                */

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

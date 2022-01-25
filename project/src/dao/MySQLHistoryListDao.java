package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.HistoryList;
import utility.Connector;

public class MySQLHistoryListDao implements HistoryListDao {

	@Override
	public List getHistory(String userid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList HL=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql="SELECT i.main_image_path, i.category_id, i.item_name, h.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM history h INNER JOIN item i ON h.item_id=i.item_id INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE h.user_id='"+userid+"' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id,h.user_id ORDER BY h.history_date DESC limit 20";

        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, h.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM history h INNER JOIN item i ON h.item_id=i.item_id INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id,h.user_id ORDER BY h.history_date DESC limit 20
        	*/

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                HistoryList h=new HistoryList();

                h.setMainImagePath(rs.getString(1));
                h.setCategoryId(rs.getInt(2));
                h.setItemName(rs.getString(3));
                h.setItemId(rs.getInt(4));
                h.setShopId(rs.getString(5));
                h.setItemPrice(rs.getInt(6));
                h.setCategoryName(rs.getString(7));
                h.setShopName(rs.getString(8));
                h.setFavoriteCount(rs.getInt(9));

                HL.add(h);
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
		return HL;
	}

}

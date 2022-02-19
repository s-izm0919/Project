package dao;
import java.math.BigDecimal;
import  java.sql.Connection;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;
import utility.Connector;

public class MySQLItemDao implements ItemDao{
	public List getItemsItemName(String itemname) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(itemname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 ORDER BY item_register_date DESC";
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 AND item_name like '%"+itemname+"%' ORDER BY item_register_date DESC";
            }


            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemPrice(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

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

    public List getItemsShopName(String shopname) {

    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(shopname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 ORDER BY item_register_date DESC";
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%"+shopname+"%') ORDER BY item_register_date DESC";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemId(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

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
    //いいねを除く
    public List getItemsItemName(String itemname, String sort) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(itemname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 order by "+sort;
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 AND item_name like '%"+itemname+"%' order by "+sort;
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemId(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

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
    public List getItemsShopName(String shopname, String sort) {

    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(shopname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 order by "+sort;
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND unused=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%"+shopname+"%') order by "+sort;
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemId(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

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
    //いいねソート用
    public List getItemsItemNameFavorite(String itemname) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(itemname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item.item_id, item_name, item_price, main_image_path, shop_id ,count(favorite.item_id) from item left join favorite on item.item_id=favorite.item_id where item_is_open=1 AND unused=1 group by item_id order by count(favorite.item_id) desc";
            }else {
            	sql="select item.item_id, item_name, item_price, main_image_path, shop_id ,count(favorite.item_id) from item left join favorite on item.item_id=favorite.item_id where item_is_open=1 AND unused=1 AND item_name like '%"+itemname+"%' group by item_id order by count(favorite.item_id) desc";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemId(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

                //ここでカウントは取得しない

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
    public List getItemsShopNameFavorite(String shopname) {

    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(shopname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item.item_id, item_name, item_price, main_image_path, shop_id ,count(favorite.item_id) from item left join favorite on item.item_id=favorite.item_id where item_is_open=1 AND unused=1 group by item_id order by count(favorite.item_id) desc";
            }else {
            	sql="select item.item_id, item_name, item_price, main_image_path, shop_id ,count(favorite.item_id) from item left join favorite on item.item_id=favorite.item_id where item_is_open=1 AND unused=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%\"+shopname+\"%') group by item_id order by count(favorite.item_id) desc";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
                Item i=new Item();

                BigDecimal _itemid =rs.getBigDecimal(1);
				int itemid=_itemid.intValue();
				i.setItemId(itemid);

                i.setItemName(rs.getString(2));

                BigDecimal _itemprice =rs.getBigDecimal(3);
				int itemprice=_itemprice.intValue();
				i.setItemId(itemprice);

                i.setMainImagePath(rs.getString(4));

                i.setShopId(rs.getString(5));

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

    @Override
	public int getSearchItemCount(String itemname) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        int count = 0;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(itemname==null) {
            	sql="select COUNT(*) from item where item_is_open=1 AND unused=1 ORDER BY item_register_date DESC";
            }else {
            	sql="select COUNT(*) from item where item_name like '%"+itemname+"%' AND item_is_open=1 AND unused=1 ORDER BY item_register_date DESC";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            rs.next();
            count = rs.getInt(1);

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
		return count;
	}

	@Override
	public int getSearchShopCount(String shopname) {

		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        int count = 0;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql=null;
            if(shopname==null) {
            	sql="select COUNT(*) from item where item_is_open=1 AND unused=1";
            }else {
            	sql="select COUNT(*) from item where item_is_open=1 AND unused=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%"+shopname+"%')";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            rs.next();
            count = rs.getInt(1);

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
		return count;
	}
	public void addItem(Item item) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            //item_register_dateはデフォルトでsysdateが設定されているので入れていない
            String sql="insert into item(item_id, item_name, item_price, item_explanation, main_image_path, category_id, item_data_path, shop_id, item_is_open)" + " values(?,?,?,?,?,?,?,?,?) ";

            st=cn.prepareStatement(sql);

            st.setString(1, null);	//AUTO_INCREMENTのため
            st.setString(2, item.getItemName());
            st.setInt(3, item.getItemPrice());
            st.setString(4, item.getItemExplanation());
            st.setString(5, item.getMainImagePath());
            st.setInt(6, item.getCategoryId());
            st.setString(7, item.getItemDataPath());
            st.setString(8, item.getShopId());
            st.setInt(9, item.getItemIsOpen());


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
	public void updateItem(Item item) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            //データに変更がない項目は取ってきたデータをcommand内で再びsetすること
            //(setしないとnullで上書きされるため)
            String sql="update item set item_name=?, item_price=?, item_explanation=?, main_image_path=?, category_id=?, item_data_path=?, item_is_open=? where item_id=?";

            st=cn.prepareStatement(sql);

            st.setString(1, item.getItemName());
            st.setInt(2, item.getItemPrice());
            st.setString(3, item.getItemExplanation());
            st.setString(4, item.getMainImagePath());
            st.setInt(5, item.getCategoryId());
            st.setString(6, item.getItemDataPath());
            st.setInt(7, item.getItemIsOpen());
            st.setInt(8, item.getItemId());

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
	public void removeItem(int itemid) {

		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="update item set unused=0 where item_id="+itemid;

            st=cn.prepareStatement(sql);

            st.executeUpdate();

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
            System.out.println(e.getMessage());
        }
        finally{
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








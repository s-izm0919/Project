package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.ItemSearch;
import bean.SearchDetail;
import utility.Connector;

public class MySQLItemSearchDao implements ItemSearchDao {

	@Override
	public List getItemSearch(String itemname) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	if(itemname==null) {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC";
        	}else {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE i.item_name LIKE '%"+itemname+"%' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC";
        	}
        	System.out.println(sql);
        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC
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

                //????????????????????????List???????????????
                //if(rs.last()) {
                //	i.setSearchCount(rs.getRow());
                //}

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
	public List getItemSearch(String itemname, String sort) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        //User u = null;
        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	if(itemname==null) {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id";
        	}else {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE i.item_name LIKE '%"+itemname+"%' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id";
        	}
        	if(sort!=null) {	//sort???null?????????????????????????????????????????????????????????
        		sql+=" ORDER BY"+sort;
        	}

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

                //????????????????????????List???????????????
                if(rs.last()) {
                	i.setSearchCount(rs.getRow());
                }

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
	public List getItemSearchDetail(SearchDetail searchDetail) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	String searchWord=searchDetail.getSearchWord();
        	int sort=searchDetail.getSort();
        	int category=searchDetail.getSelectCategory();
        	int maxPrice=searchDetail.getMaxPrice();

        	sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as favorite FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1";

        	//???????????????
        	if(searchWord!=null) {
        		sql+=" AND i.item_name LIKE '%"+searchWord+"%'";
        	}

        	//?????????????????????????????????????????????????????????
        	if(category!=0) {
        		sql+=" AND i.category_id="+category;
        	}

        	//????????????
        	//?????????????????????????????????????????????4294967295??????????????????(price???????????????????????????(int unsigned))
        	//????????????0????????????????????????
        	sql+=" AND i.item_price<="+maxPrice;

        	sql+=" GROUP BY item_id";

        	//??????????????????????????????sort=0(?????????)
        	//if???????????????????????????????????????0??????????????????JSP?????????????????????????????????????????????ok
        	if(sort==0) {			//?????????
        		sql+=" ORDER BY i.item_register_date DESC";
        	}else if(sort==1) {		//????????????
        		sql+=" ORDER BY favorite DESC, i.item_register_date DESC";
        	}else if(sort==2) {		//??????????????????
        		sql+=" ORDER BY i.item_price DESC, i.item_register_date DESC";
        	}else if(sort==3) {		//??????????????????
        		sql+=" ORDER BY i.item_price ASC, i.item_register_date DESC";
        	}

        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC
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

                //????????????????????????List???????????????
                //if(rs.last()) {
                //	i.setSearchCount(rs.getRow());
                //}

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
	public List getShopSearch(String shopname) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	if(shopname==null) {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC";
        	}else {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE s.shop_name LIKE '%"+shopname+"%' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC";
        	}

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

                /*??????????????????
                //????????????????????????List???????????????
                if(rs.last()) {
                	i.setSearchCount(rs.getRow());
                }
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
	public List getShopSearch(String shopname,String sort) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        //User u = null;
        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	if(shopname==null) {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id";
        	}else {
        		sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE s.shop_name LIKE '%"+shopname+"%' AND shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id";
        	}
        	if(sort!=null) {	//sort???null?????????????????????????????????????????????????????????
        		sql+=" ORDER BY"+sort;
        	}

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

                //????????????????????????List???????????????
                if(rs.last()) {
                	i.setSearchCount(rs.getRow());
                }

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
	public List getShopSearchDetail(SearchDetail searchDetail) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	String searchWord=searchDetail.getSearchWord();
        	int sort=searchDetail.getSort();
        	int category=searchDetail.getSelectCategory();
        	int maxPrice=searchDetail.getMaxPrice();

        	sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as favorite FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1";

        	//???????????????
        	if(searchWord!=null) {
        		sql+=" AND s.shop_name LIKE '%"+searchWord+"%'";
        	}

        	//?????????????????????????????????????????????????????????
        	if(category!=0) {
        		sql+=" AND i.category_id="+category;
        	}

        	//????????????
        	//?????????????????????????????????????????????4294967295??????????????????(price???????????????????????????(int unsigned))
        	//????????????0????????????????????????
        	sql+=" AND i.item_price<="+maxPrice;

        	sql+=" GROUP BY item_id";

        	//??????????????????????????????sort=0(?????????)
        	//if???????????????????????????????????????0??????????????????JSP?????????????????????????????????????????????ok
        	if(sort==0) {			//?????????
        		sql+=" ORDER BY i.item_register_date DESC";
        	}else if(sort==1) {		//????????????
        		sql+=" ORDER BY favorite DESC, i.item_register_date DESC";
        	}else if(sort==2) {		//??????????????????
        		sql+=" ORDER BY i.item_price DESC, i.item_register_date DESC";
        	}else if(sort==3) {		//??????????????????
        		sql+=" ORDER BY i.item_price ASC, i.item_register_date DESC";
        	}

        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC
        	*/

        	System.out.println(sql);

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

                //????????????????????????List???????????????
                //if(rs.last()) {
                //	i.setSearchCount(rs.getRow());
                //}

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
	public List getCategorySearch(int categoryid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Items=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	String sql=null;
        	sql="SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) as favorite FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1";
        	if(categoryid!=0) {
        		sql+=" AND i.category_id="+categoryid;
        	}
        	sql+=" GROUP BY item_id ORDER BY i.item_register_date DESC";
        	/*
        	SELECT i.main_image_path, i.category_id, i.item_name, i.item_id, i.shop_id, i.item_price, c.category_name, s.shop_name, (SELECT COUNT(f.item_id) FROM favorite f WHERE i.item_id=f.item_id) FROM item i INNER JOIN category c ON i.category_id=c.category_id INNER JOIN shop s ON i.shop_id=s.shop_id WHERE shop_is_open=1 AND s.unused=1 AND item_is_open=1 AND i.unused=1 GROUP BY item_id ORDER BY i.item_register_date DESC
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

                //????????????????????????List???????????????
                //if(rs.last()) {
                //	i.setSearchCount(rs.getRow());
                //}

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

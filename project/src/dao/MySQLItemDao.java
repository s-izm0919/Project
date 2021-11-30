package dao;
import java.math.BigDecimal;
import  java.sql.Connection;
import  java.sql.DriverManager;
import  java.sql.PreparedStatement;
import  java.sql.ResultSet;
import  java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.Item;

public class MySQLItemDao implements ItemDao{
	public List getItemsItemName(String itemname) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Items=new ArrayList();
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            String sql=null;
            if(itemname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 ORDER BY item_register_date DESC";
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_name like '%"+itemname+"%'AND item_is_open=1 ORDER BY item_register_date DESC";
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
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
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
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            String sql=null;
            if(shopname==null) {	//検索文字がnullのとき全部検索する
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1";
            }else {
            	sql="select item_id, item_name, item_price, main_image_path, shop_id from item where item_is_open=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%"+shopname+"%')";
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
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
        return Items;
    }

	@Override
	public int searchItemCount(String itemname) {
		int count = 0;
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            String sql=null;
            if(itemname==null) {
            	sql="select COUNT(*) from item where item_is_open=1 ORDER BY item_register_date DESC";
            }else {
            	sql="select COUNT(*) from item where item_name like '%"+itemname+"%'AND item_is_open=1 ORDER BY item_register_date DESC";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            rs.next();
            count = rs.getInt(1);
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
		return count;
	}

	@Override
	public int searchShopCount(String shopname) {
		int count = 0;
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
             cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
            String sql=null;
            if(shopname==null) {
            	sql="select COUNT(*) from item where item_is_open=1";
            }else {
            	sql="select COUNT(*) from item where item_is_open=1 AND shop_id =ANY (select shop_id from shop where shop_name like '%"+shopname+"%')";
            }

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            rs.next();
            count = rs.getInt(1);
            cn.commit();
        }catch(ClassNotFoundException e){
        	System.out.println(e.getMessage());
        }catch(SQLException e){
            try{
                cn.rollback();
            }catch(SQLException e2){
            	System.out.println(e2.getMessage());
            }
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
                try{
                    if(cn !=null){
                        cn.close();
                    }
                }catch(SQLException e3){
                	System.out.println(e3.getMessage());
                }
            }
        }
		return count;
	}
	public void addItem(Item item) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);
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
	public void updateItem(Item item) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            //データに変更がない項目は取ってきたデータをcommand内で再びsetすること
            //(setしないとnullで上書きされるため)
            String sql="update item set item_name=?, item_price=?, item_explanation=?, main_image_path=?, category_id=?, item_data_path=?, item_is_open=? where item_id=?";

            st.setString(1, item.getItemName());
            st.setInt(2, item.getItemPrice());
            st.setString(3, item.getItemExplanation());
            st.setString(4, item.getMainImagePath());
            st.setInt(5, item.getCategoryId());
            st.setString(6, item.getItemDataPath());
            st.setInt(7, item.getItemIsOpen());
            st.setInt(8, item.getItemId());


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
	public void removeItem(int itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	Class.forName("com.mysql.cj.jdbc.Driver");
            cn = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/project?characterEncoding=UTF-8&serverTimezone=JST",
			"booth","pass");

            cn.setAutoCommit(false);

            String sql="update item set unused=0 where item_id="+itemid;

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
package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.Connector;

public class MySQLHistoryDao implements HistoryDao {

	@Override
	public void removeHistoryItem(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

        	int i_id=Integer.parseInt(itemid);
            String sql="DELETE FROM history WHERE user_id='"+userid+"' AND item_id="+i_id;

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

	@Override
	public void addHistoryItem(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

        	int i_id=Integer.parseInt(itemid);
        	String sql="INSERT INTO history VALUES('"+userid+"',"+itemid+",DEFAULT)";

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
	//ショップが商品を削除または非公開にしたときユーザの該当商品の履歴を消す
	public void removeHistoryShopItem(String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

        	int i_id=Integer.parseInt(itemid);
            String sql="DELETE FROM history WHERE item_id="+i_id;

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
	public void removeHistory(String userid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="DELETE FROM history WHERE user_id='"+userid+"'";

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

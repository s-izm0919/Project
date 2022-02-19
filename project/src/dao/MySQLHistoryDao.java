package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.History;
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
	public History getHistory(String userId,String itemId){

        Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        History h = null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT * FROM history WHERE user_id='"+userId+"' AND item_id="+itemId;

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            h=new History();


            if(rs.next()==true) {

            	h.setUserId(rs.getString(1));
            	h.setItemId(rs.getInt(2));
            	h.setHistoryDate(rs.getString(3));
            }else {
            	h=null;
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
        return h;
    }

	public void updateHistoryItem(String userid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();

        	int i_id=Integer.parseInt(itemid);
        	String sql="UPDATE history SET history_date=sysdate() WHERE user_id='"+userid+"' AND item_id="+itemid;

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

package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import bean.Orders;
import utility.Connector;

public class MySQLOrdersDao implements OrdersDao {

	@Override
	public void addOrder(Orders od) {

        Connection cn=null;
        PreparedStatement st=null;

        try{
        	cn = Connector.getInstance().beginTransaction();
            //

            String sql="INSERT INTO orders VALUES (null,?,?,?,DEFAULT,?) ";

            st=cn.prepareStatement(sql);

            st.setString(1, od.getUserId());
            st.setString(2, od.getShopId());
            st.setInt(3, od.getTotalPayment());
            int boost=0;
            boost=od.getBoostAmount();
            st.setInt(4, boost);

            st.executeUpdate();

            Connector.getInstance().commit();

        }catch(SQLException e){
            Connector.getInstance().rollback();
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

	@Override
	//ユーザーの最新のorderidを持ってくるので他のコマンドで転用不可
	public Orders getOederId(String userid,String shopid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        Orders o = null;

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="SELECT o.user_id, o.order_id, MAX(purchase_date) FROM orders o LEFT OUTER JOIN item i ON o.shop_id=i.shop_id WHERE o.user_id='"+userid+"' AND o.shop_id='"+shopid+"' GROUP BY o.user_id,i.shop_id";

            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            o=new Orders();

            rs.next();

            o.setUserId(rs.getString(1));
            o.setOrderId(rs.getInt(2));
            o.setPurchaseDate(rs.getString(3));//orderidを持ってくるために書いたのでおそらく使うことはない

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
        return o;
	}

}

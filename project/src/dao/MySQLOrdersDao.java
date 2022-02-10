package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

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

            String sql="SELECT user_id, order_id, purchase_date FROM orders WHERE purchase_date = (SELECT MAX(purchase_date) FROM orders WHERE user_id='"+userid+"' AND shop_id='"+shopid+"') AND user_id='"+userid+"' AND shop_id='"+shopid+"'";

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



    public List getShopEarning(String shopId,String month) {
    	Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        List Orders=new ArrayList();

        try{
        	cn = Connector.getInstance().beginTransaction();

            String sql="select * " +
            			"from orders os " +
            			//"INNER JOIN order_detail od ON os.order_id=od.order_id " +
            			"where purchase_date LIKE '"+month+"%' AND os.shop_id='"+shopId+"';";



            st=cn.prepareStatement(sql);

            rs=st.executeQuery();

            while(rs.next()){
                Orders o=new Orders();
                o.setOrderId(rs.getInt(1));
                o.setUserId(rs.getString(2));
                o.setShopId(rs.getString(3));
                o.setTotalPayment(rs.getInt(4));
                o.setPurchaseDate(rs.getString(5));
                o.setBoostAmount(rs.getInt(6));


                Orders.add(o);
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
        return Orders;
    }

}
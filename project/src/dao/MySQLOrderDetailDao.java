package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import utility.Connector;

public class MySQLOrderDetailDao implements OrderDetailDao {

	@Override
	public void addOrderDetail(String orderid, String itemid) {
		Connection cn=null;
        PreparedStatement st=null;
        try{
        	cn = Connector.getInstance().beginTransaction();
            //
        	if(orderid!=null && itemid!=null) {
	            String sql="INSERT INTO order_detail VALUES(?,?)";

	            st=cn.prepareStatement(sql);
	            st.setString(2, orderid);
	            st.setInt(1, Integer.parseInt(itemid));

	            st.executeUpdate();
        	}

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

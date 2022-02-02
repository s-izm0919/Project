package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OrderList;
import utility.Connector;

public class MySQLOrderListDao implements OrderLIstDao {

	@Override
	public List getOrderList(String shopid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList Orders=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	//商品が削除されている場合も表示する
            String sql="SELECT o.order_id, o.purchase_date, o.total_payment, u.user_name, u.user_id FROM orders o LEFT OUTER JOIN user u ON o.user_id=u.user_id WHERE o.shop_id='"+shopid+"' ORDER BY purchase_date DESC";

            st=cn.prepareStatement(sql);
            rs=st.executeQuery();
            OrderList o=null;
            while(rs.next()){

	             o=new OrderList();

	            o.setOrderId(rs.getInt(1));
	            o.setPurchaseDate(rs.getString(2));
	            o.setOrderPrice(rs.getInt(3));
	            o.setUserName(rs.getString(4));
	            o.setUserId(rs.getString(5));

	            Orders.add(o);
            }

            /*
			SELECT o.order_id, o.purchase_date, o.total_payment, u.user_name, u.user_id FROM orders o LEFT OUTER JOIN user u ON o.user_id=u.user_id ORDER BY purchase_date DESC
            */

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

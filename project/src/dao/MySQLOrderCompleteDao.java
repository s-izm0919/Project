package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import bean.OrderComplete;
import utility.Connector;

public class MySQLOrderCompleteDao implements OrderCompleteDao {

	@Override
	public List getOrderDetail(String orderid) {
		Connection cn=null;
        PreparedStatement st=null;
        ResultSet rs=null;

        ArrayList OD=new ArrayList();
        try{
        	cn = Connector.getInstance().beginTransaction();

        	//notnullとunusedはいれていない
        	String sql="SELECT s.shop_sellerword, s.shop_name, s.shop_id, o.order_id, i.item_data_path, i.item_id, i.item_name FROM orders o LEFT OUTER JOIN order_detail od ON o.order_id=od.order_id LEFT OUTER JOIN item i ON od.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id  WHERE o.order_id="+orderid;
            st=cn.prepareStatement(sql);

            rs=st.executeQuery();
            while(rs.next()){
            	OrderComplete o=new OrderComplete();

                o.setShopExplanation(rs.getString(1));
                o.setShopName(rs.getString(2));
                o.setShopId(rs.getString(3));
                o.setOrderId(rs.getInt(4));
                o.setItemDataPath(rs.getString(5));
                o.setItemId(rs.getInt(6));
                o.setItemName(rs.getString(7));

                /*
				SELECT s.shop_explanation, s.shop_name, s.shop_id, o.order_id, i.item_data_path, i.item_id, i.item_name FROM orders o LEFT OUTER JOIN order_detail od ON o.order_id=od.order_id LEFT OUTER JOIN item i ON od.item_id=i.item_id LEFT OUTER JOIN shop s ON i.shop_id=s.shop_id
                */

                OD.add(o);
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
		return OD;
	}

}

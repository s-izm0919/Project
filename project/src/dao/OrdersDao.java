package dao;

import bean.Orders;

public interface OrdersDao {
	public void addOrder(Orders od);
	public Orders getOederId(String userid,String shopid);
}

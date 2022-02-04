package dao;

import java.util.Date;
import java.util.List;

import bean.Orders;

public interface OrdersDao {
	public void addOrder(Orders od);
	public Orders getOederId(String userid,String shopid);
	public List getShopEarning(String shopId,Date month);
}

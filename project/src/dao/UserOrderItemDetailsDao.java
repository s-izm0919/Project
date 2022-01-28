package dao;
import bean.UserOrderItemDetails;

public interface UserOrderItemDetailsDao{
	public UserOrderItemDetails getOrderInfo(String itemid,String userid);
}
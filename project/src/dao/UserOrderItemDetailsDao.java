package dao;
import java.util.List;

public interface UserOrderItemDetailsDao{
	public List getOrderInfo(String itemid,String userid);
}
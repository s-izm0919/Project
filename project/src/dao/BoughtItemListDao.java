package dao;
import java.util.List;

public interface BoughtItemListDao{
	public List getOrderInfo(String itemid,String userid);
}
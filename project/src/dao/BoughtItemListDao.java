package dao;
import java.util.List;

public interface BoughtItemListDao{
	public List getAllOrderInfo(String itemid,String userid);
}
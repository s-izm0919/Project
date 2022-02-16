package dao;
import java.util.List;

public interface BoughtItemListDao{
	public List getAllOrderInfo(String userid);
	public boolean checkOrderInfo(String userid, String itemid);
}
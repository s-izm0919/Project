package dao;
import java.util.List;
public interface OrderConfirmDao {
	public List confirmOrder(String userid, String shopid);
}

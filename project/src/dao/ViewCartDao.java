package dao;
import java.util.List;

import bean.ViewCart;
public interface ViewCartDao {
	//public List getCartItem(String userid);
	public List getCartItem(String userid, String shopid);
	public ViewCart getOneCartItem(String userid, String itemid);
}

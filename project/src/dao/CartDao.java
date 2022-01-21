package dao;

import bean.Cart;

public interface CartDao {
	public void addCart(String userid,String itemid);
	public Cart checkCart(String userid,String itemid);
	public void removeItemShop(String itemid);
	public void removeCartItem(String userid,String itemid);
	public void removeCartItemShop(String userid,String shopid);
}

package dao;

public class MySQLDaoFactory extends AbstractDaoFactory {
 public UserDao getUserDao() {
  return new MySQLUserDao();
 }
	public ItemDao getItemDao() {
 		return new MySQLItemDao();
	}
	public ShopDao getShopDao() {
		return new MySQLShopDao();
	}
}

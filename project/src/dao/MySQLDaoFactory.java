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
	public FavoriteDao getFavoriteDao() {
		return new MySQLFavoriteDao();
	}
	public ItemImageDao getItemImageDao() {
		return new MySQLItemImageDao();
	}
	/*
	public CartDao getCartDao() {
		return new MySQLCartDao();
	}
	public CategoryDao getCategoryDao() {
		return new MySQLCategoryDao();
	}
	public OrdersDao getOrdersDao() {
		return new MySQLOrdersDao();
	}
	public OrderDetailDao getOrderDetailDao() {
		return new MySQLOrderDetailDao();
	}
	public ChatDao getChatDao() {
		return new MySQLChatDao();
	}
	public UserChatMessageDao getUserChatMessageDao() {
		return new MySQLUserChatMessageDao();
	}
	public ShopChatMessageDao getShopChatMessageDao() {
		return new MySQLShopChatMessageDao();
	}
	public UserChatNotificationDao getUserChatNotificationDao() {
		return new MySQLUserChatNotificationDao();
	}
	public ShopChatNotificationDao getShopChatNotificationDao() {
		return new MySQLShopChatNotificationDao();
	}
	public FollowDao getFollowDao() {
		return new MySQLFollowDao();
	}
	public HistoryDao getHistoryDao() {
		return new MySQLHistoryDao();
	}
	public AdministratorDao getAdministratorDao() {
		return new MySQLAdministratorDao();
	}
	public AdministratorMessageDao getAdministratorMessageDao() {
		return new MySQLAdministratorMessageDao();
	}
	*/
}
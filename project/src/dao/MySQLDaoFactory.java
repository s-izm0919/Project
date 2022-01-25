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
	@Override
	public ShopItemListDao getShopItemListDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new  MySQLShopItemListDao();
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

	public ItemSearchDao getItemSearchDao() {
		return new MySQLItemSearchDao();
	}
	public NewItemDao getNewItemDao() {
		return new MySQLNewItemDao();
	}
	public ItemDetailsDao getItemDetailsDao() {
		return new MySQLItemDetailsDao();
	}
	public ShopItemListDao getShopItemListDao() {
		return new MySQLShopItemListDao();
	}
	public ItemEditDao getItemEditDao() {
		return new MySQLItemEditDao();
	}
	public OrderLIstDao getOrderLIstDao() {
		return new MySQLOrderLIstDao();
	}
	public ShopOrderItemDetailsDao getShopOrderItemDetailsDao() {
		return new MySQLShopOrderItemDetailsDao();
	}
	public ViewCartDao getViewCartDao() {
		return new MySQLViewCartDao();
	}
	public OrderConfirmDao getOrderConfirmDao() {
		return new MySQLOrderConfirmDao();
	}
	public OrderCompleteDao getOrderCompleteDao() {
		return new MySQLOrderCompleteDao();
	}
	public BoughtItemListDao getBoughtItemListDao() {
		return new MySQLBoughtItemListDao();
	}
	public UserOrderItemDetailsDao getUserOrderItemDetailsDao() {
		return new MySQLUserOrderItemDetailsDao();
	}

	*/
}

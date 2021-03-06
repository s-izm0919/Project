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

	public ShopItemListDao getShopItemListDao() {
		// TODO 自動生成されたメソッド・スタブ
		return new  MySQLShopItemListDao();
	}

	public CartDao getCartDao() {
		return new MySQLCartDao();
	}
	public BoughtItemListDao getBoughtItemListDao() {
		return new MySQLBoughtItemListDao();
	}
	public UserOrderItemDetailsDao getUserOrderItemDetailsDao() {
		return new MySQLUserOrderItemDetailsDao();
	}

	public OrdersDao getOrdersDao() {
		return new MySQLOrdersDao();
	}

	public OrderDetailDao getOrderDetailDao() {
		return new MySQLOrderDetailDao();
	}

	public OrderCompleteDao getOrderCompleteDao() {
		return new MySQLOrderCompleteDao();
	}
	public OrderLIstDao getOrderListDao() {
		return new MySQLOrderListDao();
	}

	public ShopOrderItemDetailsDao getShopOrderItemDetailsDao() {
		return new MySQLShopOrderItemDetailsDao();
	}
	public HistoryDao getHistoryDao() {
		return new MySQLHistoryDao();
	}
	public HistoryListDao getHistoryListDao(){
		return new MySQLHistoryListDao();
	}
	public NewItemDao getNewItemDao() {
		return new MySQLNewItemDao();
	}
	/*
	public CategoryDao getCategoryDao() {
		return new MySQLCategoryDao();
	}
	public CategoryDao getCategoryDao() {
		return new MySQLCategoryDao();
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

	public AdministratorDao getAdministratorDao() {
		return new MySQLAdministratorDao();
	}
	public AdministratorMessageDao getAdministratorMessageDao() {
		return new MySQLAdministratorMessageDao();
	}
	*/
	public ItemSearchDao getItemSearchDao() {
		return new MySQLItemSearchDao();
	}
	/*

	*/
	public ItemDetailsDao getItemDetailsDao() {
		return new MySQLItemDetailsDao();
	}
	public ItemEditDao getItemEditDao() {
		return new MySQLItemEditDao();
	}
	public ShopItemEarningDao getShopItemEarningDao() {
		return new  MySQLShopItemEarningDao();
	}

	/*
	public ShopItemListDao getShopItemListDao() {
		return new MySQLShopItemListDao();
	}



	*/
	public ViewCartDao getViewCartDao() {
		return new MySQLViewCartDao();
	}

	public OrderConfirmDao getOrderConfirmDao() {
		return new MySQLOrderConfirmDao();
	}

	/*

	public BoughtItemListDao getBoughtItemListDao() {
		return new MySQLBoughtItemListDao();
	}
	public UserOrderItemDetailsDao getUserOrderItemDetailsDao() {
		return new MySQLUserOrderItemDetailsDao();
	}

>>>>>>> refs/remotes/origin/master

	*/



}

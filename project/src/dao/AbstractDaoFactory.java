
package dao;


import  java.io.FileNotFoundException;
import  java.io.IOException;
import  java.util.Properties;

public abstract class AbstractDaoFactory{
    @SuppressWarnings("deprecation")
	public static AbstractDaoFactory getFactory(){
        AbstractDaoFactory factory=null;
        Properties prop=new Properties();

        try{


        	prop.load( AbstractDaoFactory.class.getClassLoader().getResourceAsStream("properties/dao.properties"));
        	//prop.load(new FileInputStream("C:/Users/koyama/git/project/project/src/properties/dao.properties"));


            String name=prop.getProperty("dao");

            Class c=Class.forName(name);

            factory=(AbstractDaoFactory)c.newInstance();

        } catch (FileNotFoundException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (IOException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (ClassNotFoundException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (InstantiationException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		} catch (IllegalAccessException e) {
			// 実際には独自例外にラップしてスローする
			throw new RuntimeException(e.getMessage(), e);
		}
        return factory;
        }
        public abstract UserDao getUserDao();
        public abstract ItemDao getItemDao();
        public  abstract ShopDao getShopDao();
        public abstract  ShopItemListDao getShopItemListDao();

        public abstract ItemSearchDao getItemSearchDao();
        public abstract ItemDetailsDao getItemDetailsDao();
        public abstract FavoriteDao getFavoriteDao();
        public abstract ItemImageDao getItemImageDao();

        public abstract CartDao getCartDao();
        public abstract ViewCartDao getViewCartDao();
        public abstract OrderConfirmDao getOrderConfirmDao();
        public abstract OrdersDao getOrdersDao();
        public abstract OrderDetailDao getOrderDetailDao();
        public abstract OrderCompleteDao getOrderCompleteDao();
        /*
        public abstract CartDao getCartDao();
        public abstract CategoryDao getCategoryDao();


        public abstract ChatDao getChatDao();
        public abstract UserChatMessageDao getUserChatMessageDao();
        public abstract ShopChatMessageDao getShopChatMessageDao();
        public abstract UserChatNotificationDao getUserChatNotificationDao();
        public abstract ShopChatNotificationDao getShopChatNotificationDao();
        public abstract FollowDao getFollowDao();
        public abstract HistoryDao getHistoryDao();
        public abstract AdministratorDao getAdministratorDao();
        public abstract AdministratorMessageDao getAdministratorMessageDao();
        public abstract NewItemDao getNewItemDao();
        public abstract ShopItemListDao getShopItemListDao();
        public abstract ItemEditDao getItemEditDao();
        public abstract OrderLIstDao getOrderLIstDao();
        public abstract ShopOrderItemDetailsDao getShopOrderItemDetailsDao();
        public abstract ViewCartDao getViewCartDao();


        public abstract BoughtItemListDao getBoughtItemListDao();
        public abstract UserOrderItemDetailsDao getUserOrderItemDetailsDao();
        public abstract HistoryListDao getHistoryListDao();
        */

    }

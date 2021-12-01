package dao;

import java.util.List;

import bean.Shop;

public interface ShopDao {
	public void addShop(Shop shopInfo);
    public Shop getShopInfo(String shopId);
    public void updateShop(Shop shopInfo);
    //public void removeShop(String User);//ユーザー管理名、パスワードを入力する仮
    public List getShopNamesSearchItem(String searchWord);//検索時の商品表示に使用
    public List getShopNamesSearchShop(String searchWord);//検索時の商品表示に使用
}

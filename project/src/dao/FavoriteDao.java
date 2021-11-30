package dao;

import java.util.List;

import bean.Favorite;

public interface FavoriteDao {
	public List getSearchItemFavoriteCount(String itemName);
	public List getSearchShopFavoriteCount(String shopName);

}

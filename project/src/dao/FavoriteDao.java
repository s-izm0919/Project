package dao;

import java.util.List;

public interface FavoriteDao {
	public List getSearchItemFavoriteCount(String itemName);
	public List getSearchShopFavoriteCount(String shopName);

}
//
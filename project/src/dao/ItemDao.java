package dao;
import java.util.List;

import bean.Item;
public interface ItemDao {
    public List getItemsItemName(String itemname);
    public List getItemsShopName(String shopname);
    public List getItemsItemName(String itemname,String sort);		//仮　検索文字と並び替え順の文字を引数にする
    																			//"item_register_date DESC"
    																			//"item_price ASC"など※いいね順を除く
    public List getItemsShopName(String shopname,String sort);		//仮
    public List getItemsItemNameFavorite(String itemname);			//いいね順用
    public List getItemsShopNameFavorite(String shopname);
    public int getSearchItemCount(String itemname);
    public int getSearchShopCount(String shopname);
    public void addItem(Item item);
    public void updateItem(Item item);
    public void removeItem(int itemid);
}

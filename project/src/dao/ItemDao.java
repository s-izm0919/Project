package dao;
import java.util.List;

import bean.Item;
public interface ItemDao {
    public List getItemsItemName(String iname);
    public List getItemsShopName(String sname);
    public List getItemsItemName(String iname,String sort);		//仮　検索文字と並び替え順の文字を引数にする
    																			//"item_register_date DESC"
    																			//"item_price ASC"など※いいね順を除く
    public List getItemsShopName(String sname,String sort);		//仮
    public int getSearchItemCount(String itemname);
    public int getSearchShopCount(String shopname);
    public void addItem(Item item);
    public void updateItem(Item item);
    public void removeItem(int itemid);
}

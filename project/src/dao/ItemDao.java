package dao;
import java.util.List;

import bean.Item;
public interface ItemDao {
    public List getItemsItemName(String iname);
    public List getItemsShopName(String sname);
    public int getSearchItemCount(String itemname);
    public int getSearchShopCount(String shopname);
    public void addItem(Item item);
    public void updateItem(Item item);
    public void removeItem(int itemid);
}

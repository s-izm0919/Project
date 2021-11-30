package dao;
import java.util.List;

import bean.Item;
public interface ItemDao {
    public List getItemsItemName(String itemname);
    public List getItemsShopName(String shopname);
    public int searchItemCount(String itemname);
    public int searchShopCount(String shopname);
    public void addItem(Item item);
    public void updateItem(Item item);
    public void removeItem(int itemid);
}

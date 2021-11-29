package dao;
import java.util.List;
public interface ItemDao {
    public List getItemsItemName(String iname);
    public List getItemsShopName(String sname);
    public int searchItemCount(String iname);
    public int searchShopCount(String sname);
}

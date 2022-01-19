package dao;
import java.util.List;

public interface ItemSearchDao {
	public List getItemSearch(String itemname);
	public List getItemSearch(String itemname,String sort);		//仮　検索文字と並び替え順の文字を引数にする
    																			//"item_register_date DESC"
    																			//"item_price ASC"など※いいね順を除く
	public List getShopSearch(String shopname);
	public List getShopSearch(String shopname,String sort);
}

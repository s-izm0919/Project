package dao;
import java.util.List;

import bean.SearchDetail;

public interface ItemSearchDao {
	public List getItemSearch(String itemname);
	public List getItemSearch(String itemname,String sort);		//仮
	public List getItemSearchDetail(SearchDetail searchDetail);
	public List getShopSearch(String shopname);
	public List getShopSearch(String shopname,String sort);		//仮
	public List getShopSearchDetail(SearchDetail searchDetail);
	public List getCategorySearch(int categoryid);
}

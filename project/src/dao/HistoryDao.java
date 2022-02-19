package dao;

import bean.History;

public interface HistoryDao {
	public void removeHistoryItem(String userid, String itemid);
	public void addHistoryItem(String userid, String itemid);
	public void removeHistoryShopItem(String itemid);
	public void removeHistory(String userid);
	public History getHistory(String userId,String itemId);
	public void updateHistoryItem(String userid, String itemid);
}

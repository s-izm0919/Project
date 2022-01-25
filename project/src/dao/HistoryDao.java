package dao;

public interface HistoryDao {
	public void removeHistoryItem(String userid, String itemid);
	public void addHistoryItem(String userid, String itemid);
	public void removeHistoryShopItem(String itemid);
	public void removeHistory(String userid);
}

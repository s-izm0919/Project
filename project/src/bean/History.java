package bean;
import java.io.Serializable;

public class History implements Serializable{
	private String userId;
	private int itemId;
	private String historyDate;
	public History() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public int getItemId() {
		return itemId;
	}
	public String getHistoryDate() {
		return historyDate;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setHistoryDate(String historyDate) {
		this.historyDate = historyDate;
	}
}

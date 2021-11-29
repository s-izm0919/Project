package bean;
import java.io.Serializable;

public class Cart implements Serializable{
	private String userId;
	private int itemId;
	private String addcartDate;
	public Cart() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public int getItemId() {
		return itemId;
	}
	public String getAddcartDate() {
		return addcartDate;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setAddcartDate(String addcartDate) {
		this.addcartDate = addcartDate;
	}
}

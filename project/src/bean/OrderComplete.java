package bean;
import java.io.Serializable;

public class OrderComplete implements Serializable{
	private String shopExplanation;
	private String shopName;
	private String shopId;
	private int orderId;
	private String itemDataPath;
	private int itemId;
	private String itemName;
	public OrderComplete(){
		super();
	}
	public String getShopExplanation() {
		return shopExplanation;
	}
	public String getShopName() {
		return shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public int getOrderId() {
		return orderId;
	}
	public String getItemDataPath() {
		return itemDataPath;
	}
	public void setShopExplanation(String shopExplanation) {
		this.shopExplanation = shopExplanation;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setItemDataPath(String itemDataPath) {
		this.itemDataPath = itemDataPath;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

}
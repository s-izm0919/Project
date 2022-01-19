package bean;
import java.io.Serializable;

public class OrderComplete implements Serializable{
	private String shopExplanation;
	private String shopName;
	private String shopId;
	private int orderId;
	private String itemDataPath;
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
}
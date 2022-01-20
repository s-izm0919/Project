package bean;
import java.io.Serializable;

public class UserOrderItemDetails implements Serializable{
	private String purchaseDate;
	private int orderId;
	private int totalPayment;
	private String shopName;
	private String shopId;
	private String itemImagePath;
	private String itemId;
	private String itemName;
	private int itemPrice;
	private int boostAmount;
	private String itemDataPath;
	public UserOrderItemDetails() {
		super();
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public int getOrderId() {
		return orderId;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public String getShopName() {
		return shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public String getItemImagePath() {
		return itemImagePath;
	}
	public String getItemId() {
		return itemId;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public int getBoostAmount() {
		return boostAmount;
	}
	public String getItemDataPath() {
		return itemDataPath;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public void setBoostAmount(int boostAmount) {
		this.boostAmount = boostAmount;
	}
	public void setItemDataPath(String itemDataPath) {
		this.itemDataPath = itemDataPath;
	}
}
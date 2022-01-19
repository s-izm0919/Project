package bean;
import java.io.Serializable;

public class OrderConfirm implements Serializable{
	private int userPoint;
	private String shopName;
	private String shopId;
	private String itemName;
	private String itemId;
	private String mainImagePath;
	private int totalPayment;
	private int orderPrice;
	private int orderCount;
	private int boostAmount;
	public OrderConfirm(){
		super();
	}
	public int getUserPoint() {
		return userPoint;
	}
	public String getShopName() {
		return shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public String getItemName() {
		return itemName;
	}
	public String getItemId() {
		return itemId;
	}
	public String getMainImagePath() {
		return mainImagePath;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public int getOrderCount() {
		return orderCount;
	}
	public int getBoostAmount() {
		return boostAmount;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
	public void setBoostAmount(int boostAmount) {
		this.boostAmount = boostAmount;
	}
}
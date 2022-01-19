package bean;
import java.io.Serializable;

public class ViewCart implements Serializable{
	private String shopName;
	private String shopId;
	private String itemName;
	private String itemId;
	private String mainImagePath;
	private int itemPrice;
	private int orderPrice;
	private int orderCount;
	public ViewCart(){
		super();
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
	public int getItemPrice() {
		return itemPrice;
	}
	public int getOrderPrice() {
		return orderPrice;
	}
	public int getOrderCount() {
		return orderCount;
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
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public void setOrderPrice(int orderPrice) {
		this.orderPrice = orderPrice;
	}
	public void setOrderCount(int orderCount) {
		this.orderCount = orderCount;
	}
}
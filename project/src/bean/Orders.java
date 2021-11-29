package bean;
import java.io.Serializable;

public class Orders implements Serializable{
	private int orderId;
	private String userId;
	private String shopId;
	private int totalPayment;
	private String purchaseDate;
	private int boostAmount;
	public Orders() {
		super();
	}
	public int getOrderId() {
		return orderId;
	}
	public String getUserId() {
		return userId;
	}
	public String getShopId() {
		return shopId;
	}
	public int getTotalPayment() {
		return totalPayment;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public int getBoostAmount() {
		return boostAmount;
	}
	public void setOrderId(int orderId) {
		this.orderId = orderId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public void setTotalPayment(int totalPayment) {
		this.totalPayment = totalPayment;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
	public void setBoostAmount(int boostAmount) {
		this.boostAmount = boostAmount;
	}

}

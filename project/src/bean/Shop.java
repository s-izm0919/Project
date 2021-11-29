package bean;
import java.io.Serializable;

public class Shop implements Serializable{
	private String shopId;
	private String userId;
	private String shopName;
	private String shopExplanation;
	private int shopEarning;
	private int shopIsOpen;
	private String shopSellerword;
	public Shop(){
		super();
	}
	public String getShopId() {
		return shopId;
	}
	public String getUserId() {
		return userId;
	}
	public String getShopName() {
		return shopName;
	}
	public String getShopExplanation() {
		return shopExplanation;
	}
	public int getShopEarning() {
		return shopEarning;
	}
	public int getShopIsOpen() {
		return shopIsOpen;
	}
	public String getShopSellerword() {
		return shopSellerword;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public void setShopExplanation(String shopExplanation) {
		this.shopExplanation = shopExplanation;
	}
	public void setShopEarning(int shopEarning) {
		this.shopEarning = shopEarning;
	}
	public void setShopIsOpen(int shopIsOpen) {
		this.shopIsOpen = shopIsOpen;
	}
	public void setShopSellerword(String shopSellerword) {
		this.shopSellerword = shopSellerword;
	}
}

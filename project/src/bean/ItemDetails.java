package bean;

import java.io.Serializable;

public class ItemDetails implements Serializable {
	private String itemName;
	private int itemId;
	private String mainImagePath;
	private String subImagePath;
	private String itemExplanation;
	private int itemPrice;
	private String shopName;
	private String shopId;
	private int favoriteCount;
	private String categoryName;
	private int categoryId;
	public ItemDetails() {
		super();
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getMainImagePath() {
		return mainImagePath;
	}
	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
	}
	public String getSubImagePath() {
		return subImagePath;
	}
	public void setSubImagePath(String subImagePath) {
		this.subImagePath = subImagePath;
	}
	public String getItemExplanation() {
		return itemExplanation;
	}
	public void setItemExplanation(String itemExplanation) {
		this.itemExplanation = itemExplanation;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getShopName() {
		return shopName;
	}
	public void setShopName(String shopName) {
		this.shopName = shopName;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

}

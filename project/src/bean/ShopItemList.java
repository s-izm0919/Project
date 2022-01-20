package bean;

import java.io.Serializable;

public class ShopItemList implements Serializable {
	private String itemName;
	private int itemId;
	private String mainImagePath;
	private String subImagePath;
	private int itemIsOpen;
	private int itemPrice;
	private int soldCount;
	private int soldPrice;
	private String categoryName;
	private int categoryId;
	private int favoriteCount;
	public ShopItemList() {
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
	public int getItemIsOpen() {
		return itemIsOpen;
	}
	public void setItemIsOpen(int itemIsOpen) {
		this.itemIsOpen = itemIsOpen;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public int getSoldCount() {
		return soldCount;
	}
	public void setSoldCount(int soldCount) {
		this.soldCount = soldCount;
	}
	public int getSoldPrice() {
		return soldPrice;
	}
	public void setSoldPrice(int soldPrice) {
		this.soldPrice = soldPrice;
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
	public int getFavoriteCount() {
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount) {
		this.favoriteCount = favoriteCount;
	}

}

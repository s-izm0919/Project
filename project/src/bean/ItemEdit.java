package bean;

import java.io.Serializable;

public class ItemEdit implements Serializable {
	private String itemName;
	private int itemPrice;
	private int itemId;
	private String mainImagePath;
	private String subImagePath;
	private String itemExplanation;
	private String categoryName;
	private int categoryId;
	private String itemDataPath;
	private int itemIsOpen;
	public ItemEdit() {
		super();
	}
	public String getItemName() {
		return itemName;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
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
	public String getItemDataPath() {
		return itemDataPath;
	}
	public void setItemDataPath(String itemDataPath) {
		this.itemDataPath = itemDataPath;
	}
	public int getItemIsOpen() {
		return itemIsOpen;
	}
	public void setItemIsOpen(int itemIsOpen) {
		this.itemIsOpen = itemIsOpen;
	}

}

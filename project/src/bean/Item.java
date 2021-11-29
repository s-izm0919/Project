package bean;
import java.io.Serializable;
public class Item implements Serializable{
	private int itemId;
	private String itemName;
	private int itemPrice;
	private String itemExplanation;
	private String mainImagePath;
	private int categoryId;
	private String itemRegisterDate;
	private String itemDataPath;
	private String shopId;
	private int itemIsOpen;

	public Item() {
		super();
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
	public int getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}
	public String getItemExplanation() {
		return itemExplanation;
	}
	public void setItemExplanation(String itemExplanation) {
		this.itemExplanation = itemExplanation;
	}
	public String getMainImagePath() {
		return mainImagePath;
	}
	public void setMainImagePath(String mainImagePath) {
		this.mainImagePath = mainImagePath;
	}
	public int getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}
	public String getItemRegisterDate() {
		return itemRegisterDate;
	}
	public void setItemRegisterDate(String itemRegisterDate) {
		this.itemRegisterDate = itemRegisterDate;
	}
	public String getItemDataPath() {
		return itemDataPath;
	}
	public void setItemDataPath(String itemDataPath) {
		this.itemDataPath = itemDataPath;
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public int getItemIsOpen() {
		return itemIsOpen;
	}
	public void setItemIsOpen(int itemIsOpen) {
		this.itemIsOpen = itemIsOpen;
	}

}

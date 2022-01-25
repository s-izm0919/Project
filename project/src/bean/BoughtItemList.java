package bean;
import java.io.Serializable;

public class BoughtItemList implements Serializable{
	private String itemImagePath;
	private String itemName;
	private int itemId;
	private String purchaseDate;
	public BoughtItemList(){
		super();
	}
	public String getItemImagePath() {
		return itemImagePath;
	}
	public String getItemName() {
		return itemName;
	}
	public int getItemId() {
		return itemId;
	}
	public String getPurchaseDate() {
		return purchaseDate;
	}
	public void setItemImagePath(String itemImagePath) {
		this.itemImagePath = itemImagePath;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}


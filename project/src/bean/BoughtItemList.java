package bean;
import java.io.Serializable;

public class BoughtItemList implements Serializable{
	private String itemImagePath;
	private String itemName;
	private String itemId;
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
	public String getItemId() {
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
	public void setItemId(String itemId) {
		this.itemId = itemId;
	}
	public void setPurchaseDate(String purchaseDate) {
		this.purchaseDate = purchaseDate;
	}
}


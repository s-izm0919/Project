package bean;
import java.io.Serializable;
public class ShopItemEarning implements Serializable{
	private String itemName;
	private int count;
	private int earning;
	public String getItemName() {
		return itemName;
	}
	public int getCount() {
		return count;
	}
	public int getEarning() {
		return earning;
	}
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public void setEarning(int earning) {
		this.earning = earning;
	}

}
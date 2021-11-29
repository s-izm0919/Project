package bean;
import java.io.Serializable;

public class ItemImage implements Serializable{
	private int imageId;
	private String subImagePath;
	private int itemId;
	public ItemImage() {
		super();
	}
	public int getImageId() {
		return imageId;
	}
	public String getSubImagePath() {
		return subImagePath;
	}
	public int getItemId() {
		return itemId;
	}
	public void setImageId(int imageId) {
		this.imageId = imageId;
	}
	public void setSubImagePath(String subImagePath) {
		this.subImagePath = subImagePath;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
}

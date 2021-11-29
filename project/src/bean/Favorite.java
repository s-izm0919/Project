package bean;
import java.io.Serializable;
public class Favorite implements Serializable{
	private String userId;
	private int itemId;
	private String favoriteDate;
	private int favoriteCount;	//いいね数

	public Favorite() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public int getItemId() {
		return itemId;
	}
	public void setItemId(int itemId) {
		this.itemId = itemId;
	}
	public String getFavoriteDate() {
		return favoriteDate;
	}
	public void setFavoriteDate(String favoriteDate) {
		this.favoriteDate = favoriteDate;
	}
	public void getFavoriteCount(){
		return favoriteCount;
	}
	public int setFavoriteCount(int favoriteCount){
		this.favoriteCount = favoriteCount;
	}

}

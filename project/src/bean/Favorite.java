package bean;
import java.io.Serializable;
public class Favorite implements Serializable{
	private String userId;
	private int itemId;
	private String favoriteDate;
<<<<<<< HEAD
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
	public int getFavoriteCount(){
		return favoriteCount;
	}
	public void setFavoriteCount(int favoriteCount){
		this.favoriteCount = favoriteCount;
	}
=======

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

>>>>>>> branch 'yamamoto' of git@github.com:s-izm0919/Project.git

}

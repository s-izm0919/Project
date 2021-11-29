package bean;
import java.io.Serializable;
public class Follow implements Serializable{
	private String shopId;
	private String userId;
	private String followDate;

	public Follow() {
		super();
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getFollowDate() {
		return followDate;
	}
	public void setFollowDate(String followDate) {
		this.followDate = followDate;
	}

}

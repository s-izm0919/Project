package bean;

import java.io.Serializable;

public class User implements Serializable {
	private String userId;
	private String userIdentifiedName;
	private String userName;
	private String userPassword;
	private String userMail;
	private int userPoint;


	public User() {
		super();
		// TODO 自動生成されたコンストラクター・スタブ
	}


	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserIdentifiedName() {
		return userIdentifiedName;
	}
	public void setUserIdentifiedName(String userIdentifiedName) {
		this.userIdentifiedName = userIdentifiedName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserMail() {
		return userMail;
	}
	public void setUserMail(String userMail) {
		this.userMail = userMail;
	}
	public int getUserPoint() {
		return userPoint;
	}
	public void setUserPoint(int userPoint) {
		this.userPoint = userPoint;
	}
}




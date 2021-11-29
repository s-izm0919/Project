package bean;
import java.io.Serializable;

public class UserChatNotification implements Serializable{
	private String userId;
	private String chatMessageId;
	private int messageIsConfirmed;
	public UserChatNotification() {
		super();
	}
	public String getUserId() {
		return userId;
	}
	public String getChatMessageId() {
		return chatMessageId;
	}
	public int getMessageIsConfirmed() {
		return messageIsConfirmed;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public void setChatMessageId(String chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	public void setMessageIsConfirmed(int messageIsConfirmed) {
		this.messageIsConfirmed = messageIsConfirmed;
	}

}

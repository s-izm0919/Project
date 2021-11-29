package bean;
import java.io.Serializable;
public class ShopChatNotification implements Serializable{
	private String shopId;
	private String chatMessageId;
	private int messageIsConfirmed;

	public ShopChatNotification() {
		super();
	}
	public String getShopId() {
		return shopId;
	}
	public void setShopId(String shopId) {
		this.shopId = shopId;
	}
	public String getChatMessageId() {
		return chatMessageId;
	}
	public void setChatMessageId(String chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	public int getMessageIsConfirmed() {
		return messageIsConfirmed;
	}
	public void setMessageIsConfirmed(int messageIsConfirmed) {
		this.messageIsConfirmed = messageIsConfirmed;
	}

}

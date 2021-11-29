package bean;
import java.io.Serializable;
public class ShopChatMessage implements Serializable{
	private String chatMessageId;
	private int chatRoomId;
	private String messageContent;
	private String messageDate;

	public ShopChatMessage() {
		super();
	}
	public String getChatMessageId() {
		return chatMessageId;
	}
	public void setChatMessageId(String chatMessageId) {
		this.chatMessageId = chatMessageId;
	}
	public int getChatRoomId() {
		return chatRoomId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

}

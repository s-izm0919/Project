package bean;
import java.io.Serializable;

public class UserChatMessage implements Serializable{
	private String chatMessageId;
	private int chatRoomId;
	private String messageContent;
	private String messageDate;
	public UserChatMessage() {
		super();
	}
	public String getCharMessageId() {
		return chatMessageId;
	}
	public int getChatRoomId() {
		return chatRoomId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public void setCharMessageId(String charMessageId) {
		this.chatMessageId = charMessageId;
	}
	public void setChatRoomId(int chatRoomId) {
		this.chatRoomId = chatRoomId;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}

}

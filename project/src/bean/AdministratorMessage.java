package bean;
import java.io.Serializable;

public class AdministratorMessage implements Serializable{
	private int messageId;
	private String messageTitle;
	private String messageContent;
	private String messageDate;
	private int administratorId;
	public AdministratorMessage() {
		super();
	}
	public int getMessageId() {
		return messageId;
	}
	public String getMessageTitle() {
		return messageTitle;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public String getMessageDate() {
		return messageDate;
	}
	public int getAdministratorId() {
		return administratorId;
	}
	public void setMessageId(int messageId) {
		this.messageId = messageId;
	}
	public void setMessageTitle(String messageTitle) {
		this.messageTitle = messageTitle;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public void setMessageDate(String messageDate) {
		this.messageDate = messageDate;
	}
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
}

package bean;
import java.io.Serializable;
public class Administrator implements Serializable{
	private int administratorId;
	private String administratorName;
	private String administratorPassword;

	public Administrator() {
		super();
	}
	public int getAdministratorId() {
		return administratorId;
	}
	public void setAdministratorId(int administratorId) {
		this.administratorId = administratorId;
	}
	public String getAdministratorName() {
		return administratorName;
	}
	public void setAdministratorName(String administratorName) {
		this.administratorName = administratorName;
	}
	public String getAdministratorPassword() {
		return administratorPassword;
	}
	public void setAdministratorPassword(String administratorPassword) {
		this.administratorPassword = administratorPassword;
	}

}

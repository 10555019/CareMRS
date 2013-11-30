
public class Staff {
	protected String userName; //used to login to the system, so needed to be UNIQUE
	protected String password; //used to login to the system, can be same for different user
	
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
}

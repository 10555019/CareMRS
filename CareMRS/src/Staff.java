import java.io.Serializable;
import java.util.Arrays;


public class Staff implements Serializable{
	protected String name;
	protected String userName; //used to login to the system, so needed to be UNIQUE
	protected String password; //used to login to the system, can be same for different user
	
	public String getName(){
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
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
	
	public static int checkLogin(Db db, LogAc logAc, String userName, char[] password){
		int i = 0;
		while (logAc.getDoctor(i)!=null){
			if (logAc.getDoctor(i).getUserName().equals(userName)){
				if (Arrays.equals(logAc.getDoctor(i).getPassword().toCharArray(),password))
					return 1;
			}
			i++;
		}
		i = 0;
		while (logAc.getAdmin(i)!=null){
			if (logAc.getAdmin(i).getUserName().equals(userName)){
				if (Arrays.equals(logAc.getAdmin(i).getPassword().toCharArray(),password))
					return 2;
			}
			i++;
		}		
		return 0;
	}
}

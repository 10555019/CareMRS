import java.util.Arrays;


public class Staff {
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
	
	public static boolean checkLogin(Db db, String userName, char[] password){
		int i = 0;
		while (db.getDoctor(i)!=null){
			if (db.getDoctor(i).getUserName().equals(userName)){
				if (Arrays.equals(db.getDoctor(i).getPassword().toCharArray(),password))
					return true;
			}
			i++;
		}
		i = 0;
		while (db.getAdmin(i)!=null){
			if (db.getAdmin(i).getUserName().equals(userName)){
				if (Arrays.equals(db.getAdmin(i).getPassword().toCharArray(),password))
					return true;
			}
			i++;
		}		
		return false;
	}
}

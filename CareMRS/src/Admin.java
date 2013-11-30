
public class Admin extends Staff{
	
	
	
	public static int adminSearch(String Username){
		int i = 0;
		while (Care.db.getAdmin(i) != null)
		{
			if (Username.equals(Care.db.getAdmin(i).userName))
				return i;
			i++;
		}
		return -1;
	}

}

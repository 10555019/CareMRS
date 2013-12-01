import java.awt.EventQueue;
import java.io.File;

public class Care {
	
	public static void main(String[] args) {
		
		/************************************************************************/
		/*login information:
			trial: set dummy account:
								user name: user
								password:  user
			real: load file IO here:
								load text file storing user account information
		*/
		/************************************************************************/
		
		final Db db = new Db();
		
		//load login information
		File file = new File("dat.sav");
		if (!file.exists()){
			//first time use
			Admin admin = new Admin("Superusr","user","user");
			db.addAdmin(admin);
		}
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWindow frame = new MyWindow(db);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

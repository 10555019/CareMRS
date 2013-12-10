import java.awt.EventQueue;

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
		final LogAc logAc = new LogAc();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyWindow frame = new MyWindow(db,logAc);
					
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

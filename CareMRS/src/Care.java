import java.awt.EventQueue;
import java.util.LinkedList;


public class Care {
	
	public static LinkedList<Doctor> doctor = new LinkedList<Doctor>();
	
	
	public static void main(String[] args) {
		
		//TESTING HERE......
		
		//WELCOME...HELLO
		
		//IT IS WORKING...
		
		//PUSHING...
		
		//commit
		
		/************************************************************************/
		/*login information:
			trial: set dummy account:
								user name: user
								password:  user
			real: load file IO here:
								load text file storing user account information
		*/
		
		//set dummy account start
		doctor.add(new Doctor("Doctor A","user","user",1)); //creates one doctor
		/************************************************************************/
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}

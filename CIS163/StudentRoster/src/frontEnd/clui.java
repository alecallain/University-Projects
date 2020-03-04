package frontEnd;

import backEnd.Student;
import exceptions.InvalidGpaException;
import exceptions.InvalidIdException;
import exceptions.LowGpaException;

public class clui {

	public static void main(String [] args) {
		Student Joe = new Student();
		try {
			Joe.setId(-442);
			Joe.setGpa(3);
		}
		catch (InvalidIdException ex) {
			System.out.println("Sorry you cant set an id for that number");
			//ex.printStackTrace();
		}
		catch (InvalidGpaException e) {
			
		}
		catch (LowGpaException e) {
			
		}
		finally {
			System.out.println(Joe);
		}
		
	}
	
}

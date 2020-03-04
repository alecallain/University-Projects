package backEnd;

import exceptions.InvalidGpaException;
import exceptions.InvalidIdException;
import exceptions.LowGpaException;

public class Student {
	
	private int id;
	private String fName;
	private String lName;
	private float gpa;
	private String email;
	
	public Student() {
		id = 0;
		fName = "";
		lName = "";
		gpa = 0;
		email = "";
	}
	
	/**
	 * Set Id
	 * @param id
	 * @throws InvalidIdException
	 */
	public void setId(int id) throws InvalidIdException {
		if (id < 0 || id > 5000) {
			throw new InvalidIdException("You cant have a negative number for and ID");
		}
		else if (id > 5000) {
			throw new InvalidIdException("Your ID number is bigger than 5000");
		}
		else {
			this.id = id;
		}
	}
	
	public void setGpa(float gpa) throws LowGpaException, InvalidGpaException {
		if (gpa < 0 || gpa > 4) {
			throw new InvalidGpaException("Invalid GPA number");
		}
		this.gpa = gpa;
		if (gpa < 2.0) {
			throw new LowGpaException("Bad egg");
		}
	}
	
	public String toString() {
		String result = "";
		return result;
	}

}

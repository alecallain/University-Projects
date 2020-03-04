
public class Employee {
	
	private String name;
	private int ssn;
	private Employee spouse;
	
	public Employee () {
		name = "";
		ssn = 0;
		spouse = null;
	}
	
	public void setSpouse(Employee h) {
		this.spouse = h;
	}
	
	public int getSsn() {
		return this.ssn;
	}
	
	public String toString() {
		return "Hi! My name is " + this.name + ". My ssn is " + this.ssn + ".";
	}
	
}

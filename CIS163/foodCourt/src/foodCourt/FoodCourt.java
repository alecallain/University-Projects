package foodCourt;

/**************************
 * This class simulates a
 * food court
 * 
 * @author Alec Allain
 * @author Trevor Sundelius
 * @author Colton Scranton
 * @due 4/12/17
 *************************/
public class FoodCourt extends Person {
	// instance variable section
	
	protected int cashierTime;
	protected int leaveTime;
	protected int eateryTime;
	
	/** instance variable description */
	
	public FoodCourt() {
		
	}
	
	/*****************
	 * main method for class
	 ****************/
	public static void main(String [] args) {
		FoodCourt court = new FoodCourt();
	}

	@Override
	public void setCashiersTime(int time) {
		// TODO Auto-generated method stub
		this.cashierTime = time;
		
	}

	@Override
	public void setLeaveTime(int time) {
		// TODO Auto-generated method stub
		this.leaveTime = time;
		
	}

	@Override
	public void setEateryTime(int time) {
		// TODO Auto-generated method stub
		this.eateryTime = time;
		
	}
	
}

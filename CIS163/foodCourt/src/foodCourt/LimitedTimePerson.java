package foodCourt;

/**
 * 
 * @author Alec Allain
 * @author Trevor Sundelius
 * @author Colton Scranton
 */
public class LimitedTimePerson extends Person {
	
	int cashiersTime;
	int eateryTime;
	int leaveTime;
	
	public LimitedTimePerson() {
		cashiersTime = 0;
		eateryTime = 0;
		leaveTime =  0;
	}

	@Override
	public void setCashiersTime(int time) {
		// TODO Auto-generated method stub
		this.cashiersTime = time;
	}

	@Override
	public void setLeaveTime(int time) {
		// TODO Auto-generated method stub
		this.leaveTime = time;
		leaveTime = (int) (leaveTime * 0.5);
	}

	@Override
	public void setEateryTime(int time) {
		// TODO Auto-generated method stub
		this.eateryTime = time;
		eateryTime = (int) (eateryTime * 0.5);
	}

}

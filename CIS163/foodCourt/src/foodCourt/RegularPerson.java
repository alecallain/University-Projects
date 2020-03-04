package foodCourt;

public class RegularPerson extends Person {

	int cashiersTime;
	int eateryTime;
	int leaveTime;
	
	public RegularPerson() {
		cashiersTime = 0;
		eateryTime = 0;
		leaveTime = 0;
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
	}

	@Override
	public void setEateryTime(int time) {
		// TODO Auto-generated method stub
		this.eateryTime = time;
	}

}

package foodCourt;

public class SpecialNeedsPerson extends Person {

	private double cashiersTime;
	private double leaveTime;
	private double eateryTime;	
	
	public SpecialNeedsPerson() {
		
		cashiersTime = 0;
		leaveTime = 0;
		eateryTime = 0;
		
	 }  
	
	/**
	 * main method for class
	 */
	public static void main(String[] args) {
		 SpecialNeedsPerson special = new SpecialNeedsPerson();
		 special.setCashiersTime(100);
		 special.setEateryTime(500);
		 special.setLeaveTime(800);
		 
		 special.getEateryTime();
	 }
	
	@Override
	public void setCashiersTime(int time) {
		// TODO Auto-generated method stub
		this.cashiersTime = time;
	 	cashiersTime = cashiersTime * 2;
		
	}

	@Override
	public void setLeaveTime(int time) {
		// TODO Auto-generated method stub
		this.leaveTime = time;
		leaveTime = leaveTime * 3;
	}

	@Override
	public void setEateryTime(int time) {
		// TODO Auto-generated method stub
		 this.eateryTime = time;
		 eateryTime = eateryTime * 4;
	}
	
}

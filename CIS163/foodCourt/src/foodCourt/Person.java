package foodCourt;

/**
 * @author   Roger Ferguson
 */
public class Person {
	
	private int tickTime;
	private Eatery Destination;

	//public abstract void setCashiersTime(int time);
	
	//public abstract void setLeaveTime(int time);
	
	//public abstract void setEateryTime(int time);
	
	// max time person stays in line
	protected double boothTime;
	
	public double getBoothTime() {
		return boothTime;
	}
	
	public Eatery getDestination() {
		return Destination;
	}

	public void setDestination(Eatery destination) {
		Destination = destination;
	}
	
	public int getTickTime() {
		return tickTime;
	}

	public void setTickTime(int tickTime) {
		this.tickTime = tickTime;
	}

	public void setEateryTime(double time) {
		this.boothTime = time;
	}
	
	public double getEateryTime() {
		return boothTime;
	}

	public void setCashiersTime(int time) {
		// TODO Auto-generated method stub
		
	}

	public void setLeaveTime(int time) {
		// TODO Auto-generated method stub
		
	}

	public void setEateryTime(int time) {
		// TODO Auto-generated method stub
		
	}
	
	
}

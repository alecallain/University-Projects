import package foodCourt.ClockListener;

public class TestPerson implements ClockListener {

	public final int gotBoard = 1200;
	public final int fellAsleep = 1500;
	private String name = "";
	
	public TestPerson(String name) {
		
	}
	
	public void event(int tick) {
		if (tick >= 1200) {
			System.out.println("Person walked off...");
		}
		if (tick == 1500) {
			System.out.println("Person fell asleep...");
		}
	}
	
}

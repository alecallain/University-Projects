package foodCourt;

/**
 * @author Roger Ferguson
 *
 */
public class Sim {
	
	public static void main (String[] args) {
			
			Clock clk = new Clock();
			Eatery booth = new Eatery();
			Cashier cash = new Cashier();

			//int numOfTicksNextPerson = 20 
			//int averageBoothTime = 20
			
			PersonProducer produce = new PersonProducer(booth, cash, 20, 18, 20);	
			clk.add(produce);
			clk.add(booth);
			
			clk.run(10000);
			
			System.out.println("Through put is: " + booth.getThroughPut() + " people.");
			System.out.println("People that are still in the Q:" + booth.getLeft() + " people.");
			System.out.println ("Max Q length:" + booth.getMaxQlength() + " people.");
		}
	
	}

package foodCourt;

import java.util.Random;

/**
 * @author Roger Ferguson
 */
public class PersonProducer implements ClockListener {
	
	private int nextPerson = 0;
 	private Eatery eatery;
 	private Cashier cashier;
 	private int numOfTicksNextPerson;
 	private int averageEateryTime;
 	private int averageCashierTime;
 	
 	private Random r = new Random();
 	
 	public PersonProducer(Eatery eatery,
 			Cashier cashier,
 			int numOfTicksNextPerson, 
 			int averageEateryTime,
 			int averageCashierTime) {
 		
 		this.eatery = eatery;
 		this.cashier = cashier;
 		this.numOfTicksNextPerson = numOfTicksNextPerson;
 		this.averageEateryTime = averageEateryTime;
 		this.averageCashierTime = averageCashierTime;
 		//r.setSeed(13);    // This will cause the same random numbers
 	}
 	
 	public void event(int tick) {
 		if (nextPerson <= tick) {
 			nextPerson = tick + numOfTicksNextPerson;
 			
 			Person person = new Person();
 			
 			int rNumber = (int)(Math.random() * 100);
 
 			person.setEateryTime(averageEateryTime*0.5*r.nextGaussian() + averageEateryTime +.5);
 			person.setEateryTime(averageCashierTime*0.5*r.nextGaussian() + averageCashierTime +.5);
 			person.setTickTime(tick);
 			eatery.add(person);
 			cashier.add(person);
 		//	person.setDestination(theLocationAfterTheEatery);  // You can save off where the person should go.
 		}
 	
 	}

}


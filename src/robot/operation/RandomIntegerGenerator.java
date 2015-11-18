/************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																*
* Date: 09-Nov-2013; modified: 21-Jun-2014																	*
* Comment: Returns a random value in a certain range. This class actually uses Java's <code>Random</code>	*									
* 	class and system time to make a random value.															*
*************************************************************************************************************/


package robot.operation;

import java.util.Date;
import java.util.Random;

public class RandomIntegerGenerator {
	/**
	 * returns value from 0 to <code>range</code>-1
	 * @param range value to be returned is from 0 to <code>range</code>-1.
	 * @return random value
	 */
	public int nextInt(int range) {
		Date t = new Date();
		
		long randomTime =  t.getTime() + new Random().nextInt(100);
		//System.out.println(randomTime);///test
		
		int randomValue = (int) ((randomTime) % range);
		
		return randomValue;
	}
	
}

/************************************************************************************************************
 * Developer: Minhas Kamal (IIT, DU, BSSE-0509)																*
 * Date: 02-Jun-2013; Modified: 03-Nov-2013																	*
 * Comment: Verifies if the any player wins.																*
*************************************************************************************************************/

package mainFrame.operation;

public class Verification {
	/**
	 * Takes a 3*3 array & returns an integer depending on the values.
	 * If the combination is matched then returns 1 else returns 0.
	 * @param move a 3*3 array of <code>char</code>.
	 * @return if some one wins returns 1 else returns 0.
	 */
	public int verify(Move move){
		int i;
	    for(i=0; i<3; i++)  //row & column match
	    {
	        if(move.getMove(i, 0)==move.getMove(i, 1) && move.getMove(i, 0)==move.getMove(i, 2)) return 1;
	        if(move.getMove(0, i)==move.getMove(1, i) && move.getMove(0, i)==move.getMove(2, i)) return 1;
	    }

	    if(move.getMove(0, 0)==move.getMove(1, 1) && move.getMove(1, 1)==move.getMove(2, 2)) return 1; //angle match
	    if(move.getMove(0, 2)==move.getMove(1, 1) && move.getMove(1, 1)==move.getMove(2, 0)) return 1;

	    return 0;
	}
}

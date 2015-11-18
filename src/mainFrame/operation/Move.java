/************************************************************************************************************
 * Developer: Minhas Kamal (IIT, DU, BSSE-0509)																*
 * Date: 02-Jun-2013; Modified: 03-Nov-2013																	*
 * Comment: Makes a 3*3 array. The constructor initializes the array by integers 1-9.						*
 * 	One can collect & change the value of array from outside.												*
*************************************************************************************************************/

package mainFrame.operation;

public class Move {
	/**
	 * Player's move collector. Works as an under level board. 
	 */
	private char move[][] = new char[3][3];	
	
	public Move() {
		initialize();
	}
	
	/**
	 * Returns specific move in the cell.
	 * @param i row
	 * @param j column
	 * @return char in specific cell
	 */
	public char getMove(int i, int j) {		//get method
		return move[i][j];
	}
	
	/**
	 * Sets a move in the board.
	 * @param i	row
	 * @param j column
	 * @param move player's symbol
	 */
	public void setMove(int i, int j, char move) {		//set method
		this.move[i][j] = move;
	}
	
	/**
	 * Initializes the array by integers 1-9.
	 */
	public void initialize(){
		int i, j, k=49;
        for(i=0; i<3; i++){		//assigning values
            for(j=0; j<3; j++){
                setMove(i, j, (char)k);
                k++;
            }
        }
	}
}

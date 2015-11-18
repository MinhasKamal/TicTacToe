/************************************************************************************************************
* Developer: Minhas Kamal(BSSE-0509, IIT, DU)																*
* Date: 02-Jun-2013; modified: 08-Jun-2013, 02-Dec-2013														*
* Comment: This is a class that can take decision depending on the input values. It is the <b>first</b> 	*
* 	smart system that I had built, I had no knowledge over AI. So one may find it really disgusting logic	*
* 	But I think it's good as long as it works good!!!														*									
*************************************************************************************************************/


package robot.operation;

import mainFrame.operation.Move;


public class ComputerMove {
	private static int comp_sel;	//made it static to preserve previous value
	
	/**
	 * This is a complex system of <code>IF-ELSE</code> that can analyze and make decision depending on the state of the
	 * game.
	 * @param i First input is the state of the game. (There are 9 states altogether.)
	 * @param humnSelection Second input is the previous human move.
	 * @param level Third input is the thinking power level of the computer. 1-good, 2-best
	 * @param move Fourth input is the 3*3 array which represents all the given moves(both computer & human).
	 * @return Depending on the inputs the class returns a value between 1-9.
	 */
	public int move(int i, int humnSelection, int level, Move move)
	{
		RandomIntegerGenerator rand = new RandomIntegerGenerator();	//creates Random object
	    int s=1;					//for random use

	    /**initial move**/
	    if(i==0)
	    {
	        s=(rand.nextInt(1000)%9)+1;
	        if(s%2==0 && level==2) comp_sel=5;
	        else comp_sel=s;
	    }
	    else if(i==1)
	    {
	        if(humnSelection==5)
	        {
	            s=(rand.nextInt(1000)%9)+1;
	            if(s==5) comp_sel=7;
	            else if(s%2==0) comp_sel=s-1;
	            else comp_sel=s;
	        }
	        else if(level==1)
	        {
	            s=(rand.nextInt(1000)%9)+1;
	            if(s%2==0) comp_sel=s-1;
	            else comp_sel=s;
	        }
	        else return 5;
	    }
	    else if(i==2)
	    {
	        if(comp_sel==5)
	        {
	            if(humnSelection%2==0)
	            {
	                s=(rand.nextInt(1000)%9)+1;
	                if(s%2==0 || s==5) comp_sel=3;
	                else comp_sel=s;
	            }
	            else if(humnSelection==1) comp_sel=9;
	            else if(humnSelection==9) comp_sel=1;
	            else if(humnSelection==3) comp_sel=7;
	            else if(humnSelection==7) comp_sel=3;
	        }
	        else
	        {
	            if(humnSelection%2==0) comp_sel=5;
	            else if(humnSelection==5) comp_sel=(rand.nextInt(1000)%4)+1;
	            else comp_sel=(comp_sel+humnSelection)/2;
	        }
	    }
	    
	    /**tertiary move**/
	    else
	    {
	        int j;
	        
	        /**matching move**/
	        for(j=0; j<3; j++)
	        {
	            if(move.getMove(j, 0)=='O' && move.getMove(j, 0)==move.getMove(j, 1) && move.getMove(j, 2)<60) return 3*(j+1);
	            if(move.getMove(j, 0)=='O' && move.getMove(j, 0)==move.getMove(j, 2) && move.getMove(j, 1)<60) return 3*(j+1)-1;
	            if(move.getMove(j, 1)=='O' && move.getMove(j, 1)==move.getMove(j, 2) && move.getMove(j, 0)<60) return 3*(j+1)-2;

	            if(move.getMove(0, j)=='O' && move.getMove(0, j)==move.getMove(1, j) && move.getMove(2, j)<60) return 7+j;
	            if(move.getMove(0, j)=='O' && move.getMove(0, j)==move.getMove(2, j) && move.getMove(1, j)<60) return 4+j;
	            if(move.getMove(1, j)=='O' && move.getMove(1, j)==move.getMove(2, j) && move.getMove(0, j)<60) return 1+j;
	        }
	        if(move.getMove(0, 0)=='O' && move.getMove(0, 0)==move.getMove(1, 1) && move.getMove(2, 2)<60) return 9;
	        if(move.getMove(0, 0)=='O' && move.getMove(0, 0)==move.getMove(2, 2) && move.getMove(1, 1)<60) return 5;
	        if(move.getMove(1, 1)=='O' && move.getMove(1, 1)==move.getMove(2, 2) && move.getMove(0, 0)<60) return 1;

	        if(move.getMove(0, 2)=='O' && move.getMove(0, 2)==move.getMove(1, 1) && move.getMove(2, 0)<60) return 7;
	        if(move.getMove(0, 2)=='O' && move.getMove(0, 2)==move.getMove(2, 0) && move.getMove(1, 1)<60) return 5;
	        if(move.getMove(2, 0)=='O' && move.getMove(2, 0)==move.getMove(1, 1) && move.getMove(0, 2)<60) return 3;
	        
	        /**blocking move**/
	        for(j=0; j<3; j++)
	        {
	            if(move.getMove(j, 0)=='X' && move.getMove(j, 0)==move.getMove(j, 1) && move.getMove(j, 2)<60) return 3*(j+1);
	            if(move.getMove(j, 0)=='X' && move.getMove(j, 0)==move.getMove(j, 2) && move.getMove(j, 1)<60) return 3*(j+1)-1;
	            if(move.getMove(j, 1)=='X' && move.getMove(j, 1)==move.getMove(j, 2) && move.getMove(j, 0)<60) return 3*(j+1)-2;

	            if(move.getMove(0, j)=='X' && move.getMove(0, j)==move.getMove(1, j) && move.getMove(2, j)<60) return 7+j;
	            if(move.getMove(0, j)=='X' && move.getMove(0, j)==move.getMove(2, j) && move.getMove(1, j)<60) return 4+j;
	            if(move.getMove(1, j)=='X' && move.getMove(1, j)==move.getMove(2, j) && move.getMove(0, j)<60) return 1+j;
	        }
	        if(move.getMove(0, 0)=='X' && move.getMove(0, 0)==move.getMove(1, 1) && move.getMove(2, 2)<60) return 9;
	        if(move.getMove(0, 0)=='X' && move.getMove(0, 0)==move.getMove(2, 2) && move.getMove(1, 1)<60) return 5;
	        if(move.getMove(1, 1)=='X' && move.getMove(1, 1)==move.getMove(2, 2) && move.getMove(0, 0)<60) return 1;

	        if(move.getMove(0, 2)=='X' && move.getMove(0, 2)==move.getMove(1, 1) && move.getMove(2, 0)<60) return 7;
	        if(move.getMove(0, 2)=='X' && move.getMove(0, 2)==move.getMove(2, 0) && move.getMove(1, 1)<60) return 5;
	        if(move.getMove(2, 0)=='X' && move.getMove(2, 0)==move.getMove(1, 1) && move.getMove(0, 2)<60) return 3;
	        
	        /**plan breaker move**/
	        if(i==3 && level==2)
	        {
	            if(move.getMove(1, 1)=='O')
	            {
	                if(move.getMove(0, 1)==move.getMove(1, 2) || move.getMove(0, 1)==move.getMove(2, 2) || move.getMove(0, 0)==move.getMove(1, 2)) return 3;
	                else if(move.getMove(0, 1)==move.getMove(1, 0) || move.getMove(0, 1)==move.getMove(2, 0) || move.getMove(0, 2)==move.getMove(1, 0)) return 1;
	                else if(move.getMove(1, 0)==move.getMove(2, 1) || move.getMove(1, 0)==move.getMove(2, 2) || move.getMove(0, 0)==move.getMove(2, 1)) return 7;
	                else if(move.getMove(2, 1)==move.getMove(1, 2) || move.getMove(2, 1)==move.getMove(0, 2) || move.getMove(2, 0)==move.getMove(1, 2)) return 9;
	                else if(move.getMove(0, 0)==move.getMove(2, 2) || move.getMove(0, 2)==move.getMove(2, 0))
	                {
	                    int y=(rand.nextInt(1000)%8+1);
	                    if(y%2==0) return y;
	                    else return (y+1);
	                }
	            }
	            else if(move.getMove(1, 1)=='X')
	            {
	                if(move.getMove(0, 0)>60 && move.getMove(2, 2)>60) return 7;
	                else if(move.getMove(0, 2)>60 && move.getMove(2, 0)>60) return 9;
	            }
	        }
	        
	        /**planning move**/
	        if(move.getMove(1, 1)=='O')
	        {
	            if(move.getMove(0, 0)=='O')
	            {
	                if(move.getMove(2, 1)<60 && move.getMove(0, 1)<60) return 2;
	                else if(move.getMove(1, 2)<60 && move.getMove(1, 0)<60) return 4;
	            }
	            if(move.getMove(0, 2)=='O')
	            {
	                if(move.getMove(1, 0)<60 && move.getMove(1, 2)<60) return 6;
	                else if(move.getMove(2, 1)<60 && move.getMove(0, 1)<60) return 2;
	            }
	            if(move.getMove(2, 0)=='O')
	            {
	                if(move.getMove(0, 1)<60 && move.getMove(2, 1)<60) return 8;
	                else if(move.getMove(1, 2)<60 && move.getMove(1, 0)<60) return 4;
	            }
	            if(move.getMove(2, 2)=='O')
	            {
	                if(move.getMove(0, 1)<60 && move.getMove(2, 1)<60) return 8;
	                else if(move.getMove(1, 0)<60 && move.getMove(1, 2)<60) return 6;
	            }
	        }
	        else if(move.getMove(0, 0)<60 && move.getMove(1, 1)<60)	return 5;
	        
	        
	        /**random move**/
	        if(level==1)
	        {
	            int sl=1;
	            sl=((rand.nextInt(1000)%9)+1);
	            if(sl==5) sl=8;
	            comp_sel=sl;
	        }
	        else if(level==2)
	            while(true)
	            {
	                int sl=1;
	                sl=((rand.nextInt(1000)%9)+1);
	                if(sl==1 && move.getMove(0, 0)<60) {comp_sel=sl; break;}
	                else if(sl==2 && move.getMove(0, 1)<60) {comp_sel=sl; break;}
	                else if(sl==3 && move.getMove(0, 2)<60) {comp_sel=sl; break;}
	                else if(sl==4 && move.getMove(1, 0)<60) {comp_sel=sl; break;}
	                else if(sl==5 && move.getMove(1, 1)<60) {comp_sel=sl; break;}
	                else if(sl==6 && move.getMove(1, 2)<60) {comp_sel=sl; break;}
	                else if(sl==7 && move.getMove(2, 0)<60) {comp_sel=sl; break;}
	                else if(sl==8 && move.getMove(2, 1)<60) {comp_sel=sl; break;}
	                else if(sl==9 && move.getMove(2, 2)<60) {comp_sel=sl; break;}
	            }
	    }

	    return comp_sel;
	}

}



package selfpractice.dynamicprogramming;

/**
Minimum steps to reach a destination

Given a number line from -infinity to +infinity. You start at 0 and can go either to the left or to the right. 

The condition is that in i’th move, you take i steps.
	a) Find if you can reach a given number x
	b) Find the most optimal way to reach a given number x, if we can indeed reach it. 
	For example, 3 can be reached in 2 steps, (0, 1) (1, 3) and 
	4 can be reached in 3 steps (0, -1), (-1, 1) (1, 4).
*/


public class MinimumStepsToReachDestination {

	public static void main(String[] args) {
		int x = 4;
		System.out.println(steps(0,0,x));
	}
	
	static int steps(int source, int lastStep, int dest) {
	    // base cases
	    if (Math.abs(source) > Math.abs(dest))  
	    	return Integer.MAX_VALUE;
	    if (source == dest)     
	    	return lastStep;
	 
	    // at each point we can go either way positive or negative of number line
	    
	    // if we go on positive side
	    int pos = steps(source+lastStep+1, lastStep+1, dest);
	 
	    // if we go on negative side
	    int neg = steps(source-lastStep-1, lastStep+1, dest);
	 
	    // minimum of both cases
	    return Math.min(pos, neg);
	}
}

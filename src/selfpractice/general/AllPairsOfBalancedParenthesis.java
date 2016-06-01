package selfpractice.general;

import java.util.Arrays;

/**
 * It is a classic example of backtracking, which can be solved using recursion.
 * 
 * http://www.geeksforgeeks.org/print-all-combinations-of-balanced-parentheses/
 * 
 * Write a function to generate all possible n pairs of balanced brackets.
For example, if n=1 
{}
for n=2
{}{}
{{}}
 *
 */
public class AllPairsOfBalancedParenthesis {
	private static char[] str;		
	public static void main(String[] args) {
		int n = 1;		
		if(n > 0){
			str = new char[n*2];
			printBalancedParenthesis(n, 0, 0, 0);
		}
	}
	
	private static void printBalancedParenthesis(int n, int index, int open, int close){
		//Base Case: Print and return
		if(open == n && close == n){
			printArray();
			return;
		}else{
			// If open bracket count becomes more than the close bracket count, 
			//then put a closing bracket and call for the remaining brackets.
			if(open > close){
				str[index] = '}';
				printBalancedParenthesis(n, index+1, open, close+1);
			}
			//If open bracket count is less than n, then put an opening bracket 
			//and call for the remaining brackets.
			if(open < n){
				str[index] = '{';
				printBalancedParenthesis(n, index+1, open+1, close);
			}
		}		
	}

	private static void printArray() {
		for(int i=0; i < str.length; i++){
			System.out.print(str[i]);
		}
		System.out.println();
	}
}

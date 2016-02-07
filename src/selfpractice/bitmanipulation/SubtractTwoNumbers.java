package selfpractice.bitmanipulation;
/**
 * 1) Subtract two numbers without using arithmetic operators

Write a function subtract(x, y) that returns x-y 
where x and y are integers. The function should not use any of the 
arithmetic operators (+, ++, –, -, .. etc).
 *
 */
public class SubtractTwoNumbers {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		int ans1 = subIterative(a, b);
		System.out.println(ans1);
		
		int ans2 = subRecursion(a,b);
		System.out.println(ans2);
	}

	
	
	private static int subIterative(int a, int b) {
		
		//iterate till second no becomes 0
		while(b != 0){
			// carry now contains common set bits of 'a' and 'b'
			int borrow = (~a) & b;
			
			// Subtraction of bits of 'a' and 'b' where at least one of the bits is not set
			a = a ^ b;
			
			// Borrow is shifted by one so that subtracting it from 'a' gives the required sum
			b = borrow << 1;
		}
		return a;		 
	}



	private static int subRecursion(int a, int b) {
		if(b == 0){
			return a;
		}else{
			//Pass Sum, Carry shifted by 1 recursively
			return subRecursion(a ^ b, (~a & b) << 1);
		}		
	}

}

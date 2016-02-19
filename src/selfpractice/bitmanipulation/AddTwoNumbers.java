package selfpractice.bitmanipulation;
/**
 * 1) Add two numbers without using arithmetic operators
Write a function Add() that returns sum of two integers. 
The function should not use any of the arithmetic operators (+, ++, –, -, .. etc).
 */
public class AddTwoNumbers {

	public static void main(String[] args) {
		int a = 10;
		int b = 20;
		
		int sum1 = addIterative(a, b);
		System.out.println("Sum by iterative method : " + sum1);
		
		int sum2 = addRecursion(a,b);
		System.out.println("Sum by recursive method : " + sum2);
	}
	
	private static int addIterative(int a, int b) {
		//iterate till second no becomes 0
		while(b != 0){
			// carry now contains common set bits of 'a' and 'b'
			int carry = a & b;
			
			// Sum of bits of 'a' and 'b' where at least one of the bits is not set
			a = a ^ b;
			
			// Carry is shifted by one so that adding it to 'a' gives the required sum
			b = carry << 1;
		}
		return a;		 
	}

	private static int addRecursion(int a, int b) {
		if(b == 0){
			return a;
		}else{
			//Pass Sum, Carry shifted by 1 recursively
			return addRecursion(a ^ b, (a & b) << 1);
		}		
	}
}

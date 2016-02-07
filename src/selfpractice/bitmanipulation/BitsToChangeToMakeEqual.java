package selfpractice.bitmanipulation;
/**
 * Find the minimum number of bits to change to make two numbers equal. 
 */
public class BitsToChangeToMakeEqual {
	
	public static void main(String[] args) {
		int num1 = 5;
		int num2 = 3;
		
		//Calculate XOR
		int num3 = num1 ^ num2;		
		//Count Set Bits
		int bitsToChange = countSetBits(num3);
		System.out.println("Bits to change = "+bitsToChange);
	}
	
	private static int countSetBits(int number){
		int count = 0;
		while(number > 0){
			number = number & number-1;
			count++;
		}
		return count;
	}
}

package selfpractice.bitmanipulation;

public class CountSetBits {

	public static void main(String[] args) {		
		int number = 127;		
		//Brian Kernighan’s Algorithm
		System.out.println("Brian Kernighan : Number = " + number + " Set bits = "+countSetBits_BrianKernighan(number));
		//Brute Force
		System.out.println("Brute Force Sol : Number = " + number + " Set bits = "+bruteForceMethod(number));

	}

	//Brian Kernighan’s Algorithm : Loops as many no.of 1's are present in number
	private static int countSetBits_BrianKernighan(int number){
		int count = 0;		
		while(number > 0){	//loop and swap the last 1 bit in number. So loop till num > 0
			count++;
			number = number & number-1;
		}		
		return count;
	}

	//Brute Force : AND with 1 and right shift every bit, loops 32 times
	private static int bruteForceMethod(int number){
		int count = 0;
		for(int i =0; i < 32; i++){
			if((number & 1) == 1){
				count++;
			}
			number  = number >> 1;
		}
		return count;
	}

}

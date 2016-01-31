package selfpractice;

public class CountSetBits {

	public static void main(String[] args) {		
		int number = 15;		
		System.out.println(countSetBits(number));
	}
	
	//Loops as many no.of 1's are present in number
	private static int countSetBits(int number){
		int count = 0;		
		while(number > 0){	//loop and swap the last 1 bit in number. So loop till num > 0
			count++;
			number = number & number-1;
		}		
		return count;
	}
}

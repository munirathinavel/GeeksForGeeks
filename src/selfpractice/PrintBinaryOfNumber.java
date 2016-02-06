package selfpractice;

public class PrintBinaryOfNumber {

	public static void main(String[] args) {
		for(int i=0; i<100; i++){
			printBinary(i);
		}		
	}
	
	private static void printBinary(int num){
		int original = num;
		StringBuilder sb = new StringBuilder();		
		while(num > 0){
			if((num & 1) == 1){
				sb.append("1");
			}else{
				sb.append("0");
			}
			num >>= 1;
		}
		System.out.println(original + " -> " + sb.reverse().toString());
	}

}

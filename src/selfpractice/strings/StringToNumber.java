package selfpractice.strings;

public class StringToNumber {

	static long parseLong(String str) {
		if(str.isEmpty()){
			throw new NumberFormatException("Cannot be converted to integer");
		}
		int i=0;
		long ans=0;
		int sign=1;		//default number is +ve
		int length=str.length();
		if(str.charAt(i)==' ')
			throw new NumberFormatException("Cannot be converted to integer");
		//set sign to 1 or -1 based on + or - sign in input string
		if(str.charAt(i)=='+'||str.charAt(i)=='-'){
			sign=str.charAt(i++)=='+'?1:-1;
		}

		//Loop through rest of string characters
		for(;i<length;i++){
			int tmp=str.charAt(i)-'0';		//get integer value for character which should be between 0 to 9
			if(tmp < 0 || tmp > 9){
				throw new NumberFormatException("Cannot be converted to integer");
			}
			//Check overflow conditions
			if(ans > Long.MAX_VALUE/10||(ans == Long.MAX_VALUE/10 && Long.MAX_VALUE % 10 < tmp)){
				if(sign==1){
					return Long.MAX_VALUE;
				}else{
					return Long.MIN_VALUE;
				}
			}else{
				ans=ans*10+tmp;
			}

		}
		return sign*ans;

	}

	public static void main(String[] args) {
		String[] inputs = {"123","-123","2147483647", "-2147483648", "9223372036854775807", "-9223372036854775808", 
				"49575987457348574857348754375923", "123#45"};
		try{
			for(String inputStr : inputs){
				long outputNum = parseLong(inputStr);
				System.out.println("Input Str: "+inputStr+" => Number :"+outputNum);
			}
		}catch(NumberFormatException nfe){
			System.out.println("Cannot be converted to integer");
		}
	}
}

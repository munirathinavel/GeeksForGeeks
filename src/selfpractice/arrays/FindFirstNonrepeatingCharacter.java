package selfpractice.arrays;

/**
 * Find the first non-repeating character in a String.
 * 
 */
public class FindFirstNonrepeatingCharacter {

	public static void main(String[] args) {
		String str = "abcdabdefghc";
		
		int[] freq = new int[26];
		//increment the frequency of char index
		for(int i=0; i < str.length(); i++){
			int index = str.charAt(i) - 'a';
			freq[index]++;
		}
		
		//find first 1 i.e non-repeat char
		char c = '\0';
		for(int i=0; i < 26; i++) {
			if(freq[i] == 1) { 
				c = (char) (i + 'a'); 
				break;								
			}
		}		
		
		if(c != '\0'){
			System.out.println(c);
		}else{
			System.out.println("No non-repeating character found");
		}

	}

}

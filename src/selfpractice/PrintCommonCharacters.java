package selfpractice;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PrintCommonCharacters {

	public static void main(String[] args) {
		String s1 = "aabbccddcceefgjkjdslkjsdlgjsdsfsadfdssss";
		String s2 = "abbcddhasdkashdjbcsdsads";
		
		int[] freq1 = new int[26];
		int[] freq2 = new int[26];
		
		for(int i=0; i < s1.length(); i++){
			int index = s1.charAt(i) - 'a';
			freq1[index]++;
		}
		
		for(int i=0; i < s2.length(); i++){
			int index = s2.charAt(i) - 'a';
			freq2[index]++;
		}
		
		List<Character> l = new ArrayList<Character>();	
		for(int i=0; i < 26; i++){
			if(freq1[i] > 0 && freq2[i] > 0){
				int repeats = (freq1[i] < freq2[i]) ? freq1[i] : freq2[i];
				for(int j=0; j < repeats; j++){
					l.add((char) (i + 'a'));
					System.out.printf("%c",i + 'a');
				}				
			}
		}
		Collections.sort(l, Collections.reverseOrder());
		for(char c : l){
			System.out.println(c);
		}

	}
	
}

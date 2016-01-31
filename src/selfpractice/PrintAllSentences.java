package selfpractice;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class PrintAllSentences {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList(new String[]{"you","we"});
		List<String> list2 = Arrays.asList(new String[]{"have","are"});
		List<String> list3 = Arrays.asList(new String[]{"sleep","eat","drink"});
		
		List<List<String>> list4 = new LinkedList<List<String>>();
		list4.add(list1);
		list4.add(list2);
		list4.add(list3);
		
		printSentence(list4, "", 0);
	}
	
	private static void printSentence(List<List<String>> list4, String output, int index) {
		if(list4.size() == index){
			System.out.println(output);
			return;
		}		
		List<String> current = list4.get(index);
		
		for(String str : current){
			printSentence(list4, output + " "+ str, index+1);
		}		
	}

}

package selfpractice;

import java.util.Scanner;

public class FindElementsWithSameSum {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int noOfElements = scanner.nextInt();
		
		int[] arr = new int[noOfElements];
		for(int i=0; i<noOfElements; i++){
			arr[i] = scanner.nextInt();
		}
		
		//print arr
		for(int i=0; i<noOfElements; i++){
			System.out.println(arr[i]);
		}
		
		//
		
		scanner.close();
	}

}

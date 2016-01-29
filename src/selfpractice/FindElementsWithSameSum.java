package selfpractice;

import java.util.HashMap;
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
		System.out.println("Input Array :");
		for(int i=0; i<noOfElements; i++){
			System.out.print(arr[i] + " ");
		}
		
		System.out.println("\n"+findElemetsWithSameSum(arr));
		
		scanner.close();
	}
	
	private static String findElemetsWithSameSum(int[] arr){
		HashMap<Integer,String> map = new HashMap<Integer, String>();
		for(int i=0; i < arr.length; i++){
			for(int j=i+1; j < arr.length; j++){
				int sum = arr[i] + arr[j];
				String pair1 = "("+arr[i]+","+arr[j]+")";
				if(map.containsKey(sum)){
					String pair2 = map.get(sum);
					return pair1 + pair2;
				}else{
					map.put(sum, pair1);
				}
			}
		}
		return "No pairs found";
	}

}

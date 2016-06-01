package selfpractice.general;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 2) Given an array of distinct integers, find if there are two pairs
  (a, b) and (c, d) such that a+b = c+d, and a, b, c and d are distinct elements. 
  If there are multiple answers, then print any of them.

Input:   {3, 4, 7, 1, 12, 9};
Output:  (4, 12) and (7, 9)
Explanation: 4+12 = 7+9

Input:  {65, 30, 7, 90, 1, 9, 8};
Output:  No pairs found

 */
public class FindElementsWithSameSum {
	
	static class Pair {
		int num1,num2;
		public Pair(int num1, int num2){
			this.num1 = num1;
			this.num2 = num2;
		}
		public String getPair(){
			return "("+num1+","+num2+")";
		}
	}

	public static void main(String[] args) {
		/*Scanner scanner = new Scanner(System.in);
		int noOfElements = scanner.nextInt();
		
		int[] arr = new int[noOfElements];
		for(int i=0; i<noOfElements; i++){
			arr[i] = scanner.nextInt();
		}*/
		int[] arr = {3, 4, 7, 1, 12, 9};
		
		//print arr
		System.out.println("Input Array :");
		for(int i=0; i<arr.length; i++){
			System.out.print(arr[i] + " ");
		}
		
		findElemetsWithSameSum(arr);
		
		//scanner.close();
	}
	
	private static void findElemetsWithSameSum(int[] arr){
		HashMap<Integer,Pair> map = new HashMap<Integer, Pair>();
		
		for(int i=0; i < arr.length; i++){
			for(int j=i+1; j < arr.length; j++){
				
				int sum = arr[i] + arr[j];
				Pair pair1 = new Pair(arr[i], arr[j]);
				if(map.containsKey(sum)){
					Pair pair2 = map.get(sum);
					System.out.println("\n"+pair2.getPair() 
									+ " and "+ pair1.getPair());
					return;
				}else{
					map.put(sum, pair1);
				}
			}
		}
		System.out.println("No pairs found");
	}
	
	//Time Complexity : O(n^2) 

}

package selfpractice;

import java.util.HashMap;
import java.util.Scanner;

/**
 * 1) Given an array, find if any two numbers (multiplied by 100) total up to a target number.
Function returns boolean (True or false)

For example Array 1,2,3,4
Target is 300

Answer: True

 */
public class FindNumbersSumEqualTarget {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		System.out.println("Enter Target : ");
		int target = scanner.nextInt();
		
		System.out.println("Enter array length : ");
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
		
		boolean output = findIfSumEqualsTarget(arr, target);
		System.out.println("\n"+output);
	
		scanner.close();
	}

	//Store <target - num*100, num> in map. If another numbers <num*100> is already present in map, we know sum will equals target
	private static boolean findIfSumEqualsTarget(int[] arr, int target) {
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for(int num : arr){
			int num100 = num * 100;
			if(map.containsKey(num100)){
				//int num1 = map.get(num100);
				return true;
			}else{
				map.put(target - (num*100), num);
			}
		}		
		return false;
	}
	
	//Time complexity : O(n)

}

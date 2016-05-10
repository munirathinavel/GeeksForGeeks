package selfpractice.arrays;

import java.util.HashMap;
import java.util.Map;

/**
 * Count pairs with given sum
 * 
 * Given an array of integers, and a number ‘sum’, find the number of pairs of integers in the array 
 * whose sum is equal to sum.
 * 
Examples:
Input  :  arr[] = {1, 5, 7, -1}, 
          sum = 6
Output :  2
Pairs with sum 6 are (1, 5) and (7, -1)
 
Input  :  arr[] = {1, 5, 7, -1, 5}, 
          sum = 6
Output :  3
Pairs with sum 6 are (1, 5), (7, -1) &amp;
                     (1, 5)         
 
Input  :  arr[] = {1, 1, 1, 1}, 
          sum = 2
Output :  6
There are 3! pairs with sum 2.
 
Input  :  arr[] = {10, 12, 10, 15, -1, 7, 6, 
                   5, 4, 2, 1, 1, 1}, 
          sum = 11
Output :  9
 *
 */
public class CountPairsWithSum {

	public static void main(String[] args) {
		int[] arr = {10, 12, 10, 15, -1, 7, 6, 5, 4, 2, 1, 1, 1};
		int sum = 11;

		System.out.println("With Brute Force: Complexity O(n^2)");
		int pairs = countPairsWithSum_BruteForce(arr, sum);
		System.out.println(pairs);

		System.out.println("Using HashMap: Linear Time O(n)");
		int pairs1 = countPairsWithSum_ByHashMap(arr, sum);
		System.out.println(pairs1);

	}

	private static int countPairsWithSum_BruteForce(int[] arr, int sum) {
		int pairs = 0;
		for(int i=0; i < arr.length; i++){
			for(int j = i+1; j < arr.length; j++){
				if(arr[i] + arr[j] == sum){
					pairs++;
				}
			}
		}
		return pairs;
	}


	private static int countPairsWithSum_ByHashMap(int[] arr, int sum) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		//Find and store frequency of each number in array
		for(int num : arr) {
			if(map.containsKey(num)) {		
				int count = map.get(num);
				map.put(num, count + 1);
			} else {
				map.put(num, 1);
			}
		}

		int pairs = 0;
		for(int num : arr) {
			if(map.containsKey(sum - num)){
				pairs += map.get(sum - num);	//counting each pair 2 times
				
				//Condition for case {1,1,1,1} : 2
				if(sum - num == num){
					pairs--;
				}
			}
		}
		//Divide by 2 as we counted each pair twice
		return pairs/2;
	}

}

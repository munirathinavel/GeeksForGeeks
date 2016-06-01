package selfpractice;

import java.util.Arrays;
import java.util.Collections;

/**
 * Given an input array, create zig-zag array such that : The largest number appears first, 
 * smallest appears second, and then the remaining elements alternate between the larger numbers decreasing 
 * from the largest, and the smaller number increasing from smallest
 * 
 *   Eg 1: input array = {1,3,6,9,-3}
 *   zig-zag array =   {9,-3,6,1,3}
 *   
 *   Eg 2: input array = {5,2,7,8,-2,25,25}
 *   zig-zag array =     {25,-2,25,2,8,5,7}
 *
 */
public class ZigZagArray {

	public static void main(String[] args) {
		int[] intArr = {5,2,7,8,-2,25,25};
		
		int[] output = new int[intArr.length];
        int[] ascArr = Arrays.copyOf(intArr, intArr.length);
        Integer[] descArr = new Integer[intArr.length];
        
        for(int i=0; i<intArr.length;i++){
            descArr[i] = intArr[i];
        }
        
        Arrays.sort(ascArr);
        Arrays.sort(descArr, Collections.reverseOrder());
        
        int length = intArr.length;
        for(int i=0; i < length; i++){
            int j = (length - 1) - i;
            output[i] = descArr[i];
            int k = i+ 1;
            output[k] = descArr[j];
        }
        /*for(int i=0; i < intArr.length; i++){
            if(i%2 != 0){
            	int val = ascArr[i];
            	output[i] = val;
            }            
        }*/
        
        System.out.println("Asc");
        for(int i : ascArr){
            System.out.print(i + " ");
        }
        
        System.out.println("\nDesc");
        for(int i : descArr){
            System.out.print(i + " ");
        }
        
        System.out.println("\nOutput");
        for(int i : output){
            System.out.print(i + " ");
        }
		
		
	}

}

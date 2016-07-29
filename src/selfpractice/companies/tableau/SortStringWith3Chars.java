package selfpractice.companies.tableau;

import java.util.Arrays;

/**
 http://www.geeksforgeeks.org/sort-an-array-of-0s-1s-and-2s/
 This is a classic problem called - Dutch National Flag
 http://www.csse.monash.edu.au/~lloyd/tildeAlgDS/Sort/Flag/

 Sort an array of 0s, 1s and 2s
 Given an array A[] consisting 0s, 1s and 2s, write a function that sorts A[]. The functions should put all 0s first, then all 1s and all 2s in last.

 Example
 Input = {0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1};
 Output = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 2, 2}

 Doing the same with 3 chars (r,w,b) 0=red, 1=white, 2=blue (Dutch flag colors)

 */
public class SortStringWith3Chars {
    public static void main(String[] args) {
        SortStringWith3Chars s3 = new SortStringWith3Chars();
        String s = "wwrrrrbbbwwwbrbwwbrrbw";
        char[] result = s3.sort3Chars(s.toCharArray());

        System.out.println(Arrays.toString(result));
    }

    /**
     * 3 pointers: low=0, mid=0, high=n-1
     * while mid < high
     * if arr[mid] =
     *   = 0(r)   swap a[low], a[mid], low++, mid++
     *   = 1(w)   mid++
     *   = 2(b)   swap a[high], a[mid], high--
     */
    private char[] sort3Chars(char[] arr){
        int low = 0, mid = 0;
        int high = arr.length-1;

        while(mid < high){
            if(arr[mid] == 'r'){
                swap(low, mid, arr);
                low++;
                mid++;
            }else if(arr[mid] == 'w'){
                mid++;
            }else if(arr[mid] == 'b'){
                swap(mid, high, arr);
                high--;
            }
        }
        return arr;
    }

    private void swap(int i, int j, char[] arr){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}

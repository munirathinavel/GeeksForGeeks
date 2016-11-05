package selfpractice.companies.liveramp;

/**
 * Given an array of integers, write a method to find indices m and n such that if you sorted elements m to n,
 * the entire array would be sorted.
 * Minimize n - m (i.e find the smallest such sequence)
 *
 * Eg: input = {1,2,4,7,10,11,8,12,5,6,16,18,19}
 * m = 3
 * n = 9
 -----------------------------------------------------------------------------------------------------------------------
 Approach:
 1. Find left = longest increasing subsequence from beginning           left = 1,2,3,4,7,10,11
        right = longest increasing subsequence at end                   right = 5,6,16,18,19
        middle = left+1 to right                                        middle = 8,12

 2. Find max = maximum value in left  & middle                      max = 11    max_index = 5
         min = minimum value in right & middle                       min = 5     min_index = 8

 3. Shrink left until value less than min value             left_index = reach till 4 as (4 < 5)
    Shrink right until value greater than max value         right_index = reach till 6 as next value (16 > 11)

 */
public class SubSort {
    public static void main(String[] args) {
        SubSort obj = new SubSort();
        int[] arr = //{1,2,4,7,10,11,8,3,12,5,6,16,18,19};
                    //{1,2,6,5,5,8,9};
                    {1,2,4,7,10,11,8,12,5,6,16,18,19};
        obj.findSmallestSortSequence(arr);
    }

    private void findSmallestSortSequence(int[] arr) {

        //Find end index of left longest increasing subsequence
        int left_end = findLongestIncreasingSeqFromStart(arr);

        //Find start index of right longest increasing subsequence
        int right_start = findLongestIncreasingSeqFromEnd(arr);

        int max_index = left_end;
        int min_index = right_start;
        //check in middle too
        for(int i=left_end+1; i < right_start; i++){
            if(arr[i] < arr[min_index]) {
                min_index = i;
            }
            if(arr[i] > arr[max_index]){
                max_index = i;
            }
        }

        //Shrink left until value less than min value
        int left_index = shrinkLeft(arr, min_index, left_end);

        //Shrink right until value greater than max value
        int right_index = shrinkRight(arr, max_index, right_start);

        System.out.println("left index : " + left_index + " right index : " + right_index);
    }


    //Find end index of left longest increasing subsequence
    private int findLongestIncreasingSeqFromStart(int[] arr) {
        for(int i=0; i < arr.length-1; i++){
            if(arr[i] > arr[i+1])
                return i;
        }
        return arr.length-1;
    }

    //Find start index of right longest increasing subsequence
    private int findLongestIncreasingSeqFromEnd(int[] arr) {
        for(int i=arr.length-2; i >= 0; i--){
            if(arr[i+1] < arr[i])
                return i+1;
        }
        return 0;
    }


    //Shrink left until value less than min value
    private int shrinkLeft(int[] arr, int min_index, int left_end) {
        int min = arr[min_index];
        for(int i=left_end - 1; i >= 0; i--){
            if(arr[i] < min)
                return i+1;
        }
        return 0;
    }


    //Shrink right until value greater than max value
    private int shrinkRight(int[] arr, int max_index, int right_start) {
        int max = arr[max_index];
        for(int i=right_start; i < arr.length; i++){
            if(arr[i] >= max)
                return i-1;
        }
        return arr.length-1;
    }

}

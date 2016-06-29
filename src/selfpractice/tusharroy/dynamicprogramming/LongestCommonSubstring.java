package selfpractice.tusharroy.dynamicprogramming;

/**
 * http://en.wikipedia.org/wiki/Longest_common_substring_problem
 * Longest common substring problem
 *
 * the longest common substring problem is to find the longest string (or strings) that is a substring (or are substrings)
 * of two or more strings.
 * --------------------------------------------------------------------
 * DP Formula: (draw table and check values and derive formula)
    if (input1[i-1] == input2[j-1]){
        T[i][j] = 1 + T[i-1][j-1]
    }else{
        T[i][j] = 0
    }

 Base Cases: If any of the string is null then T[][] will be 0.

 Check if ith character in one string A is equal to jth character in string B
    Case 1: both characters are same
        T[i][j] = 1 + T[i-1][j-1] (add 1 to the result and remove the last character from both the strings and check the result for the smaller string)

    Case 2: both characters are not same.
        T[i][j] = 0

 At the end, traverse the matrix/keep track of max element and find the maximum element in it, This will the length of Longest Common Substring.
 */
public class LongestCommonSubstring {

    public static void main(String[] args) {
        LongestCommonSubstring obj = new LongestCommonSubstring();
        String str1 = "https://www.amazon.in/Dell-3541-15-6-inch-Laptop-Quad-Core/dp/B00OHW1VL4/ref=zg_bs_1375424031_5";//"abcdaf";
        String str2 = "http://www.amazon.in/Dell-3541-15-658-15-6-inch-Laptop/dp/B011V0K3DQ/ref=zg_bs_1375424031_3";//"zbcdf";

        int length = obj.getLongestCommonSubstring(str1.toCharArray(), str2.toCharArray());
        System.out.println("Length of Longest substring: "+length);
    }

    public int getLongestCommonSubstring(char[] str1, char[] str2){
        int max = 0;                                                 //Max length of substring
        int maxI = 0, maxJ = 0;                                      //Keep track of i,j where we have max length in T[][]
        int[][] T = new int[str1.length + 1][str2.length + 1];      //by default matrix will be initialized with 0

        //Find length of Longest Substring
        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                //DP Formula
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = 1 + T[i-1][j-1];
                }else{
                    T[i][j] = 0;
                }
                //Keep track of Max_Length
                if(max < T[i][j]){
                    max = T[i][j];                                  //update max length and its i,j values
                    maxI = i;
                    maxJ = j;
                }
            }
        }

        //Find the String From Longest Substring Length: Traverse Diagonal till max > 0
        StringBuilder sb = new StringBuilder();
        int temp = max;
        while(temp > 0){
            if(T[maxI][maxJ] == temp){
                sb.append(str1[maxI-1]);
            }
            temp--;
            maxI--;
            maxJ--;
        }

        System.out.println(sb.reverse().toString());
        return max;
    }

}

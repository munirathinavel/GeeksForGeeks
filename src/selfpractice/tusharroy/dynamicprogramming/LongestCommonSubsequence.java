package selfpractice.tusharroy.dynamicprogramming;

/**
 * Longest Common Subsequence
 * http://www.geeksforgeeks.org/dynamic-programming-set-4-longest-common-subsequence/
 * http://algorithms.tutorialhorizon.com/dynamic-programming-longest-common-subsequence/
 *
 * Given two sequences, find the length of longest subsequence present in both of them. A subsequence is a sequence that
 * appears in the same relative order, but not necessarily contiguous
 * --------------------------------------------------------------------------------------------------------------------
 * DP Formula: (draw table and check values and derive formula)
    if(input1[i-1] == input2[j-1]){     //match
        T[i][j] = 1 + T[i-1][j-1];
    }else{
        T[i][j] = Max(T[i-1][j] , T[i][j-1])
    }
 */
public class LongestCommonSubsequence {

    public static void main(String[] args) {
        LongestCommonSubsequence obj = new LongestCommonSubsequence();

        String str1 = "sandeepkulkarni";
        String str2 = "sadanandkulkarni";

        int length = obj.getLongestCommonSubsequence(str1.toCharArray(), str2.toCharArray());
        System.out.println("Lenght of longest common subsequence = "+ length);
    }

    private int getLongestCommonSubsequence(char[] str1, char[] str2) {
        int max = 0;
        int[][] T = new int[str1.length+1][str2.length+1];

        for(int i=1; i <= str1.length; i++){
            for(int j=1; j <= str2.length; j++){
                //DP Formula
                if(str1[i-1] == str2[j-1]){
                    T[i][j] = 1 + T[i-1][j-1];
                }else{
                    T[i][j] = Math.max(T[i-1][j], T[i][j-1]);
                }
                //Keep track and Update max
                if(max < T[i][j]){
                    max = T[i][j];
                }
            }
        }

        //below to print longest common subsequence string from T[][]
        // Start from the right-most-bottom-most corner
        StringBuilder sb = new StringBuilder();
        int i = str1.length, j = str2.length;
        while (i > 0 && j > 0){
            //If both characters are same, then its in LCS
            if(str1[i-1] == str2[j-1]){             //its diagonal as both chars same
                sb.append(str1[i-1]);
                i--;
                j--;
            }else if(T[i-1][j] > T[i][j-1]){        //move top
                i--;
            }else{                                  //move left
                j--;
            }
        }
        System.out.println(sb.reverse().toString());       //print subsequence

        return max;
    }
}

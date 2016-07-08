package selfpractice.companies.amazon;

/**
 * Longest Substring with ATMOST k distinct characters
 *
 APPROACH:
 The key is when we adjust the sliding window to satisfy the invariant, we need a counter of the
 number of times each character appears in the substring.

 Maintain distinctCharacters counter. If it becomes more than K, move window ahead and check
 Keep track of window using i, j. Keep track of max window => maxLen, maxStart (i), maxEnd(j)
 */
public class LongestSubstringWithKCharacters {
    public static void main(String[] args) {
        LongestSubstringWithKCharacters obj = new LongestSubstringWithKCharacters();
        int k = 3;
        String s = "abbaacccccdddde";

        int maxLen = obj.lengthOfLongestSubstringWithKDistinctChars(s , k);
        System.out.println(maxLen);
    }

    public int lengthOfLongestSubstringWithKDistinctChars(String s, int k) {
        int[] counts = new int[256];
        int maxLen = 0, distinctChars = 0, maxStart = 0, maxEnd = 0;
        int i = 0;
        for(int j = 0; j < s.length(); j++) {
            if(counts[s.charAt(j)] == 0){           //only when we first encounter character, increment distinct char count
                distinctChars++;
            }
            counts[s.charAt(j)]++;                  //increment frequency of char at j

            while(distinctChars > k) {             //CORE LOGIC: here k=2 => check till distinct char <= k (2)
                counts[s.charAt(i)]--;             //decrement frequency of char at i
                if(counts[s.charAt(i)] == 0) {     // i points to previous distinct character, so we loop till distinct char <= k
                    distinctChars--;
                }
                i++;
            }

            //update maxLen and start,end to get max substring
            if(j - i + 1 > maxLen){
                maxLen = j-i+1;
                maxStart = i;
                maxEnd = j;
            }
        }

        System.out.println(s.substring(maxStart, maxEnd+1));
        return maxLen;
    }
}

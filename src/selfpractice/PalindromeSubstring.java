package selfpractice;

import java.util.HashSet;
import java.util.Set;

/**
 * 
 *
 */
public class PalindromeSubstring {

	public static void main(String[] args) {
		palindromeSubStrs("aabaa");
	}


	private static void palindromeSubStrs(String str) {
		Set<String> set = new HashSet<String>();
		int n = str.length();
		int[][] result = new int[2][n+1];

		// insert pre-post characters for easy iteration
		str = "@" + str + "#";
		for(int j = 0; j <= 1; j++)
		{
			int radius = 0;
			result[j][0] = 0;
			int i = 1;
			while (i <= n)
			{
				while (str.charAt(i - radius - 1) == str.charAt(i + j + radius))
					radius++;  

				result[j][i] = radius;
				int k = 1;
				while((result[j][i - k] != radius - k) && (k < radius))
				{
					result[j][i + k] = (result[j][i - k] < radius - k) ? result[j][i - k] : radius - k;
					k++;
				}
				radius = (radius - k > 0) ? radius-k : 0;
				i += k;
			}
		}

		// remove pre-post characters
		str = str.substring(1, str.length()-1);

		set.add(""+str.charAt(0));	
		for (int i = 1; i < n-1; i++)
		{
			for (int j = 0; j <= 1; j++){
				for (int k = result[j][i]; k > 0; k--){
					set.add(str.substring(i - k - 1, i-k-1 + 2 * k + j));
				}
				set.add(""+str.charAt(i));
			}
		}
		System.out.println(set.size());
	}

}

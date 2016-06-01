package selfpractice;


import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
 
/** Class Manacher **/
public class Manacher
{
    /** function to preprocess string **/
    public static String preProcess(String str)
    {
        int len = str.length();
        if (len == 0) 
            return "^$";
        String s = "^";
        for (int i = 0; i < len; i++)
            s += "#" + str.charAt(i);         
        s += "#$";
        return s;
    }
    /** function to get largest palindromic substring **/
    public static String getLongestPalindrome(String str)
    {
        /** preprocess string **/
        char[] s = preProcess(str).toCharArray();
        int N = s.length;
        int[] p = new int[N + 1];
        int id = 0, mx = 0;
        for (int i = 1; i < N - 1; i++) 
        {
             p[i] = mx > i ? Math.min(p[2 * id - i], mx - i) : 0;
             while (s[i + 1 + p[i]] == s[i - 1 - p[i]]) 
                 p[i]++;
             if (i + p[i] > mx) 
             {
                 mx = i + p[i];
                 id = i;
             }
        }
        /** length of largest palindrome **/
        int maxLen = 0;
        /** position of center of largest palindrome **/
        int centerIndex = 0;
        for (int i = 1; i < N - 1; i++) 
        {
            if (p[i] > maxLen) 
            {
                maxLen = p[i];
                centerIndex = i;
            }
        }
        /** starting index of palindrome **/
        int pos = (centerIndex - 1 - maxLen)/2;
        return str.substring(pos , pos + maxLen);        
    }
    
    
    private static String printResult(String input){
    	Set<String> set = new HashSet<String>();
    	
    	int len = input.length();
    	for(int i=0; i<input.length(); i++){
    		String subs = getLongestPalindrome(input.substring(i, len));
    		set.add(subs);    		
    	}
    	
    	for(int i=0; i<input.length(); i++){
    		String subs = ""+input.charAt(i);
    		set.add(subs);    		
    	}
    	
    	for (String s : set) {
  	        System.out.println(s);
  	    }
    	
    	System.out.println("Size="+set.size());
    	
    	return null;
    }
    
    /** Main Function **/
    public static void main(String[] args) throws IOException
    {    
        String text = "geek";
 
        Manacher m = new Manacher(); 
        String longestPalindrome = m.printResult(text);//m.getLongestPalindrome(text); 
       // System.out.println(longestPalindrome);    
    }    
}
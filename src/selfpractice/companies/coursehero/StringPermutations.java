package selfpractice.companies.coursehero;

import java.util.ArrayList;
import java.util.List;


// "ab" -> Input

// "ab"
// "Ab"
// "aB"
// "AB"


public class StringPermutations{

    private static List<String> list = new ArrayList<String>();

    public static void main(String[] args){
        String s = "ab";

        helper(s, "");

        for(String ans : list){
            System.out.println(ans);
        }
    }

    /**
     Logic: s : shrink character by character & prefix : grows character by character
     */
    private static void helper(String s, String prefix){
        //base case
        if(s.length() == 0){
            list.add(prefix);
        }else{

            //for(int i=0; i < s.length(); i++){
            char ch = s.charAt(0);

            helper(s.substring(1, s.length()), prefix + ch);            //without toggle

            if(Character.isUpperCase(ch)){
                ch = Character.toLowerCase(ch);
            }else if(Character.isLowerCase(ch)){
                ch = Character.toUpperCase(ch);
            }

            helper(s.substring(1, s.length()), prefix + ch);            //after toggle

            //}
        }
    }

}
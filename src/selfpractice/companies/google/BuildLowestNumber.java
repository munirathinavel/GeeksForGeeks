package selfpractice.companies.google;

/**
 http://www.geeksforgeeks.org/build-lowest-number-by-removing-n-digits-from-a-given-number/
 Build Lowest Number by Removing n digits from a given number
 Given a string ‘str’ of digits and an integer ‘n’, build the lowest possible number by removing ‘n’ digits from the string
 and not changing the order of input digits.

 Examples:

 Input: str = "4325043", n = 3
 Output: "2043"

 Input: str = "765028321", n = 5
 Output: "0221"

 Input: str = "121198", n = 2
 Output: "1118"
 ---------------------------------------------------------------------------------------------------------------------
 Approach:
 1. Now we get the rules to delete digits to get the least remaining number:
    - If there is a digit which is greater than the next one, delete such first digit.
    - If all digits in the number are increasingly sorted, the last digit gets deleted.
 2. The process repeats until the required k digits are deleted.

 121198   n=2
 first digit greater than next digit = 2, so 11198, n=1
 first digit greater than next digit = 9, so 1118, n=0

 */
public class BuildLowestNumber {

    public static void main(String[] args) {
        String input = "121198";
        int n = 2;

        BuildLowestNumber obj = new BuildLowestNumber();
        String result = obj.getLowestNumber(input, n);
        System.out.println(result);
    }

    public String getLowestNumber(String str, int n){
        if(n == 0)
            return str;

        if(str.length() < n){
            return str;
        }

        StringBuilder result = new StringBuilder(str);
        while(n > 0){
            int removeIndex = getFirstDigitGreaterThanNext(result.toString());
            result.deleteCharAt(removeIndex);
            n--;
        }

        return result.toString();
    }

    private int getFirstDigitGreaterThanNext(String str) {

        for(int i=0; i < str.length() - 1; i++){
            int current = str.charAt(i) - '0';
            int next = str.charAt(i+1) - '0';
            if(current > next){
                return i;
            }
        }

        return str.length()-1;
    }


}

package selfpractice.companies.google;

/**
 Coding round - question 1
 */
public class AverageNumber {

    public static void main(String[] args) {
        AverageNumber avg = new AverageNumber();
        int x = 623315;
        int result = avg.solution(x);
        System.out.println(result);
    }

    public int solution(int X){
        //minimum digits required to find average
        if(X < 10)
            return X;

        String in = Integer.toString(X);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < in.length(); i++){
            char t = (char) Math.round((in.charAt(i)+in.charAt(i-1))/2.0);
            String prefix = "";
            String suffix = "";
            if(i > 1){                              //get number prefix
                prefix = in.substring(0,i-1);
            }
            if(i < in.length()-1){                  //get number suffix
                suffix = in.substring(i+1,in.length());
            }
            int ret = Integer.parseInt(prefix+t+suffix);    //recreate number with prefix + avg + suffix
            max = Math.max(max, ret);                       //track largest number
        }
        return max;
    }
}

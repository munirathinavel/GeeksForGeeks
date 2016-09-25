package selfpractice.companies.google;

/**
 * Created by sandeepkulkarni on 9/25/16.
 */
public class AverageNumber {

    public static void main(String[] args) {
        AverageNumber avg = new AverageNumber();
        int x = 623315;
        int result = avg.solution(x);
        System.out.println(result);
    }

    public int solution(int X){
        //minimum digits required
        if(X < 10)
            return X;

        String in = Integer.toString(X);
        int max = Integer.MIN_VALUE;
        for(int i = 1; i < in.length(); i++){
            char t = (char) Math.round((in.charAt(i)+in.charAt(i-1))/2.0);
            String prefix = "";
            String suffix = "";
            if(i > 1){
                prefix = in.substring(0,i-1);
            }
            if(i < in.length()-1){
                suffix = in.substring(i+1,in.length());
            }
            int ret = Integer.parseInt(prefix+t+suffix);
            max = Math.max(max, ret);
        }
        return max;
    }
}

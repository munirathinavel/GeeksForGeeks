package selfpractice.companies.liveramp;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 Find maximum valid time from 4 integers between [0-9]
 eg: A,B,C,D = {1,8,3,2}    Max time = 23:18
 eg: {2,4,0,0} = 20:40
 eg: {3,0,7,0} = 07:30
 eg: {9,1,9,7} = Not possible
 */
public class MaxValidTime {

    public static Set<Integer> s = new HashSet<>();

    public static void main(String[] args) {
        MaxValidTime obj = new MaxValidTime();
        int a = 7;
        int b = 0;
        int c = 0;
        int d = 3;
        //String maxTime = obj.findMaximumValidTime1(a,b,c,d);
        //System.out.println(maxTime);


        //Second approach
        String str = ""+a+b+c+d;
        obj.permutewithoutRep(str,"");
        int max = 0;
        for(int value : s){
            if(value > max){
                max = value;
            }
            System.out.println(value);
        }
        System.out.println("max value = " + max);

        if(s.isEmpty()){
            System.out.println("Not possible");
        }else{
            String ans = Integer.toString(max);
            if(ans.length() == 3){
                ans = "0"+ans;
            }
            System.out.println(ans.substring(0,2)+":"+ans.substring(2));
        }

    }


        public void permutewithoutRep(String str, String prefix){
            if(str.length()==0){
                if(Integer.parseInt(prefix.substring(0,2))<24 && Integer.parseInt(prefix.substring(2))<60){
                    s.add(Integer.parseInt(prefix));
                }
            }else{
                for(int i=0;i<str.length();i++){
                    permutewithoutRep(str.substring(0,i)+str.substring(i+1,str.length()), prefix+str.charAt(i));
                }
            }

        }


    /**
     * NOT RECOMMENDED
     * Too much complex to handle all case
     */
        private String findMaximumValidTime1(int a, int b, int c, int d) {
        int[] arr = {a,b,c,d};
        int maxHr = -1;
        int hr_i = 0, hr_j = 0;

        //Find maximum HR
        for(int i=0; i < arr.length; i++){
            for(int j=i+1; j < arr.length; j++){
                int value1 = arr[i] * 10 + arr[j];
                int value2 = arr[j] * 10 + arr[i];
                if(value1 < 24 && value2 < 24){
                    if(value1 > value2 && value1 > maxHr) {
                        maxHr = value1;
                        hr_i = i;
                        hr_j = j;
                    }else if(value2 > value1 && value2 > maxHr){
                        maxHr = value2;
                        hr_i = i;
                        hr_j = j;
                    }
                }else if(value1 < 24 && value2 > 24 && value1 > maxHr){
                    maxHr = value1;
                    hr_i = i;
                    hr_j = j;
                }else if(value2 < 24 && value1 > 24 && value2 > maxHr){
                    maxHr = value2;
                    hr_i = i;
                    hr_j = j;
                }

            }
        }
        System.out.println(maxHr);

        //Find maximum MM
        int[] mArr = new int[2];        //minutes array
        int k=0;
        for(int i=0; i < arr.length; i++){
            if(i != hr_i && i != hr_j){
                mArr[k++] = arr[i];
            }
        }

        System.out.println(Arrays.toString(mArr));
        int maxMin = -1;
        int val1 = mArr[0] * 10 + mArr[1];
        int val2 = mArr[1] * 10 + mArr[0];

        if(val1 < 60 && val2 < 60){
            maxMin = Math.max(val1,val2);
        }else if(val1 < 60 && val2 > 60) {
            maxMin = val1;
        }else if(val2 < 60 && val1 > 60){
            maxMin = val2;
        }
        System.out.println(maxMin);

        //Create answer
        StringBuilder sb = new StringBuilder();
        if(maxHr == -1 || maxMin == -1){
            return "Not Possible";
        }

        if(Integer.toString(maxHr).length() < 2){       //HR
            sb.append("0"+maxHr+":");
        }else {
            sb.append(maxHr+":");
        }

        if(Integer.toString(maxMin).length() < 2){       //MM
            sb.append("0"+maxMin);
        }else {
            sb.append(maxMin);
        }

        return sb.toString();
    }



}

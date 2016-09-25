package selfpractice.companies.vmware;

import java.util.Scanner;

/**
 * You are given only two operations, ADD_1 and MULTIPLY_2.
 * You start from 0 and using the two operations reach a number N. Find the least number of operations needed to do this.
 */
public class TwoOperations {

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int t = s.nextInt();
        for(int i=0; i < t; i++) {
            int n = s.nextInt();
            int result = minOperations(n);
            System.out.println(result);
        }
        s.close();
    }

    private static int minOperations(int n){
        int counter = 0;
        while(n != 0){
            if(n > 2 && n % 2 == 0){
                n /= 2;
            }else{
                n--;
            }
            counter++;
        }
        return counter;
    }

}

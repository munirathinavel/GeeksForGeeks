package selfpractice.companies.vmware;

public class BalanceArray {
    public static void main(String[] args) {
        BalanceArray ba = new BalanceArray();
        int[] nums = {1,1};
        int index = checkBalance(nums);
        System.out.println(index);
    }

    private static int checkBalance(int[] nums) {
        int sum = 0;
        int leftsum = 0;

        for (int i = 0; i < nums.length; i++)
            sum += nums[i];

        for(int i = 0; i < nums.length; i++) {
            sum -= nums[i];         //right sum

            if(leftsum == sum) {
                return i;
            }

            leftsum += nums[i];     //add nums[i] to leftSum
        }

        return -1;
    }
}

package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q1_LeetCode209;

public class Solution_1_n3 {

    /**
     * 暴力解法，O(n3)
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {

        if(s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

        int res = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i ; j < nums.length; j++) {//[i....j]子数组
                //计算[i....j]子数组的和
                sum = 0;
                for (int k = i; k <= j; k++) {
                    sum += nums[k];
                }
                if (sum >= s) {
                    res = Math.min(res, j-i+1);
                }
            }
        }

        if(res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}

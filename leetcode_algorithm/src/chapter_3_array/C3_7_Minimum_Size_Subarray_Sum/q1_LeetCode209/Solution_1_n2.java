package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q1_LeetCode209;

public class Solution_1_n2 {

    /**
     *  优化暴力解
     *  时间复杂度: O(n^2)
     *  空间复杂度: O(n)
     *
     * @param s
     * @param nums
     * @return
     */
    public static int minSubArrayLen(int s, int[] nums) {
        if (s <= 0 || nums == null)
            throw new IllegalArgumentException("Illigal Arguments");

//        //sums[i]存放nums[0...i-1]的和
        int[] sums = new int[nums.length+1];
        for (int i = 1; i <=nums.length; i++) {
            sums[i]=sums[i-1]+nums[i-1];
        }

        int res = nums.length + 1;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j < nums.length; j++) {//[i....j]子数组
                //计算[i....j]子数组的和
                sum = 0;
                sum += sums[j+1]-sums[i];
                if (sum >= s) {
                    res = Math.min(res, j - i + 1);
                }
            }
        }

        if (res == nums.length + 1)
            return 0;

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}

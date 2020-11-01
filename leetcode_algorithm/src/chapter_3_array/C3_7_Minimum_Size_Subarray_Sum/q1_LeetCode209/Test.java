package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q1_LeetCode209;

public class Test {

    public static int minSubArrayLen(int s, int[] nums) {
        int res = nums.length+1;
        int left = 0;
        int right = -1;//初始，窗口不存在
        int sum = 0;
        while (left < nums.length) {
            if (sum < s && right + 1 < nums.length) {
                sum += nums[++right];
            } else {
                sum -= nums[left++];
            }

            if (sum >= s) {
                res = Math.min(res, (right - left + 1));
            }
        }
        if (res == nums.length+1) {
            res =0;
        }

        return res;
    }

    public static void main(String[] args) {
        int arr[] = {2, 3, 1, 2, 4, 3};
        System.out.println(minSubArrayLen(7, arr));
    }
}

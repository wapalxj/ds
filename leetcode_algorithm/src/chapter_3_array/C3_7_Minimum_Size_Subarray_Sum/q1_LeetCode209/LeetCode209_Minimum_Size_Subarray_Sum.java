package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q1_LeetCode209;

public class LeetCode209_Minimum_Size_Subarray_Sum {
    static class Solution {
        /**
         * 滑动窗口
         * 空间复杂度O(1)
         * 时间复杂度O(n)
         */
        public static int minSubArrayLen(int s, int[] nums) {
            int left = 0, right = -1;//nums[l...r]为我们的滑动窗口
            int sum = 0;//当前子串的和
            int res = nums.length + 1;//结果长度,初始是数组长度+1

            while (left < nums.length) {//左边界还能取值
                if (right + 1 < nums.length && sum < s) {
                    sum += nums[++right];
                } else {
                    sum -= nums[left++];
                }

                if (sum >= s) {
                    res = Math.min(res, right - left + 1);
//                System.out.println(""+left+"---"+right);
                }
            }
            if (res == nums.length + 1) {
                return 0;
            }
            return res;
        }

        public static void main(String[] args) {
            int arr[] = {2, 3, 1, 2, 4, 3};
            System.out.println(minSubArrayLen(7, arr));
        }
    }

    public static int minSubArrayLen(int s, int[] nums) {
        int left = 0, right = -1;//nums[l...r]为我们的滑动窗口
        int sum=0;
        int res=nums.length+1;



        return res;
    }
}

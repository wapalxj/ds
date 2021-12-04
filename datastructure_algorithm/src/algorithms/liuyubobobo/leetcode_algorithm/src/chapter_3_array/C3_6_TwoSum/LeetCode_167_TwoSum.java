package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_6_TwoSum;

import java.util.Arrays;

public class LeetCode_167_TwoSum {

    static class Solution {
        /**
         * 对撞指针，时间复杂度O(n)
         * @param numbers
         * @param target
         * @return
         */
        public static int[] twoSum(int[] numbers, int target) {
            int left = 0;
            int right = numbers.length - 1;
            while (left < right) {
                if (numbers[left] + numbers[right] == target) {
                    return new int[]{left + 1, right + 1};//+1因为返回索引从1开始
                } else if (numbers[left] + numbers[right] < target) {
                    left++;
                } else if (numbers[left] + numbers[right] > target) {
                    right--;
                }
            }
            return new int[]{-1, -1};
        }

        public static void main(String[] args) {
            int[] numbers={2, 7, 11, 15};
            int []res=twoSum(numbers,9);
            System.out.println(Arrays.toString(res));
        }
    }
}

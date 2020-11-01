package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_3_array.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LeetCode283_Move_Zeroes {

    static class Solution {
        /**
         * 最直观的做法
         * <p>
         * 时间复杂度O(n)
         * 空间复杂度O(n)
         */
        public static void moveZeroes(int[] nums) {
            List<Integer> nonZero = new ArrayList<>();
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nonZero.add(nums[i]);
                }
            }

            for (int i = 0; i < nonZero.size(); i++) {
                nums[i] = nonZero.get(i);
            }

            for (int i = nonZero.size(); i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         * 优化1——--原地算法
         * <p>
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         */
        public static void moveZeroes2(int[] nums) {
            int k = 0;//nums中，[0,k)中的元素均为非0元素
            //遍历到第i个元素，保证[0...i]中所有非0元素
            //都按照顺序排列在[0...k)中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    nums[k++] = nums[i];
                }
            }

            //将nums剩下的圆度放0
            for (int i = k; i < nums.length; i++) {
                nums[i] = 0;
            }
        }

        /**
         * 优化2——--原地算法
         * <p>
         * 时间复杂度O(n)
         * 空间复杂度O(1)
         */
        public static void moveZeroes3(int[] nums) {
            int k = 0;//nums中，[0,k)中的元素均为非0元素
            //遍历到第i个元素，保证[0...i]中所有非0元素
            //都按照顺序排列在[0...k)中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    if (i != k) {//如果整个数组都是0
                        swap(nums, k, i);
                    }
                    k++;
                }
            }
        }

        public static void moveZeroes4(int[] nums) {
            int k = -1;//nums中，[0,k]中的元素均为非0元素
            //遍历到第i个元素，保证[0...i)中所有非0元素
            //都按照顺序排列在[0...k]中
            for (int i = 0; i < nums.length; i++) {
                if (nums[i] > 0) {
                    k++;
                    if (i != k) {
                        swap(nums, k, i);
                    }
                }

            }
        }

        //交换
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }


    public static void main(String[] args) {
        int[] arr = {1, 2, 0, 3, 12};
//                int[] arr = {0,1,2,3,4, 5, 6};
//        int[] arr = {1, 0, 2, 3, 0, 0, 4, 5, 6};
        Solution.moveZeroes4(arr);
        System.out.println(Arrays.toString(arr));
    }


}

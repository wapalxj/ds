package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_3_array.practice;

import java.util.Arrays;

public class p2_LeetCode26_Remove_Duplicates_from_Sorted_Array {


    public static void main(String[] args) {
//        int[] arr = {0,1,2,3,4, 5, 6};
        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3,4};
//        int[] arr = {1, 1, 2, 2, 3};
        int newLen = removeDuplicates(arr);
        System.out.println(Arrays.toString(arr));

    }

    public static int removeDuplicates(int[] nums) {
        int len = nums.length;
        int k = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] != nums[k]) {
                k++;//[0,k]为结果集合
                swap(nums, i, k);
            }
        }
        return k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}

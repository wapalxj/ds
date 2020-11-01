package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {

    public static void main(String[] args) {
        int[] nums = new int[]{80, 100, 50, 22, 15, 6, 1, 1000, 999, 0};
//        int[] nums = new int[]{1,2,3,4,5,6,7,9,8,10};
//        recursiveBubble(nums);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int[] nums) {
        selectionSort2(nums);
    }

    public static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {

            //寻找[i,n)区间内的最小值
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[minIndex]) {
                    minIndex = j;
                }
            }
            SortTestHelper.swap(nums, minIndex, i);
        }
    }


    private static void selectionSort2(int[] nums) {
        int len = nums.length;

        for (int i = 0; i < len; i++) {
            int posiion = i;
            for (int j = i + 1; j < len; j++) {
                if (nums[j] < nums[posiion]) {
                    posiion = j;
                }
            }
            SortTestHelper.swap(nums, posiion, i);
        }
    }
}

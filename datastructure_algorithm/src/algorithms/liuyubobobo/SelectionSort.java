package algorithms.liuyubobobo;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] nums = new int[]{1, 9, 6, 4, 5, 0, 2, 3};
        selectionSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    private static void selectionSort(int[] nums) {
        for (int i = 0; i < nums.length-1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] <nums[minIndex]) {
                    minIndex=j;
                }
            }
            swap(nums,i,minIndex);
            System.out.println(Arrays.toString(nums));
        }
    }

    private static void swap(int[] nums,int i, int j) {
        int temp=nums[i];
        nums[i]=nums[j];
        nums[j]=temp;
    }
}
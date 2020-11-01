package chapter2_sort_basic;

/**
 * 选择排序
 */
public class SelectionSort {
    public static void sort(int[] nums){
        selectionSort(nums);
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
}

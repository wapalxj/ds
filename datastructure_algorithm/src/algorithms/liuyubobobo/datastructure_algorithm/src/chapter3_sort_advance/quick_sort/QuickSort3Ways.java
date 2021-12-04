package algorithms.liuyubobobo.datastructure_algorithm.src.chapter3_sort_advance.quick_sort;


import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.InsertionSort;
import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.SortTestHelper;

import java.util.Arrays;

public class QuickSort3Ways {

    public static void main(String[] args) {
        int n = 300_000;
        int nums[] = SortTestHelper.generateRandomArray(n, 0, n);
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    //对arr[l...r]部分进行快速排序
    private static void quickSort(int[] arr, int left, int right) {
        if (right - left <= 15) {
            InsertionSort.insertionSort2(arr, left, right);
            return;
        }

        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortTestHelper.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        int v = arr[left];

        int lt = left;//arr[left+1..lt] < v
        int gt = right + 1;//arr[gt...right] > v
        int i = left + 1;//arr[lt+1...i] == v

        //i---当前考察的元素
        while (i < gt) {
            if (arr[i] < v) {
                SortTestHelper.swap(arr, i, lt + 1);
                lt++;
                i++;
            } else if (arr[i] > v) {
                SortTestHelper.swap(arr, i, gt - 1);
                gt--;
            } else {//arr[i] ==v
                i++;
            }
        }

        SortTestHelper.swap(arr, left, lt);

        //排序<v部分和>v部分
        quickSort(arr, left, lt - 1);
        quickSort(arr, gt, right);
    }
}

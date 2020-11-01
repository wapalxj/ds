package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter3_sort_advance.quick_sort;

import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.InsertionSort;
import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.SortTestHelper;
import sun.rmi.runtime.Log;

import java.util.Arrays;
import java.util.Scanner;

public class QuickSort {

    public static void main(String[] args) {
//        int n = 10;
//        int nums[] = SortTestHelper.generateRandomArray(n, 0, n);
//        sort(nums);
//        System.out.println(Arrays.toString(nums));
//        System.out.println(findKth(nums, 3));

    }

    public static void sort(int arr[]) {
        int n = arr.length;
        quickSort(arr, 0, n - 1);
    }

    //对arr[l...r]部分进行快速排序
    private static void quickSort(int[] arr, int left, int right) {
//        if (left>=right) {
//            //递归到底
//            return;
//        }

        //优化1：当元素量非常小的时候，转而使用插入排序
        if (right - left <= 15) {
            InsertionSort.insertionSort2(arr, left, right);
            return;
        }

        int p = partition2(arr, left, right);
        quickSort(arr, left, p - 1);
        quickSort(arr, p + 1, right);
    }

    //返回p，使得arr[l...p-1]<arr[p];  arr[p+1...r] >arr[p]
    private static int partition(int[] arr, int left, int right) {
        //优化2
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortTestHelper.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);

        int v = arr[left];
        //arr[left+1...j] < v   arr[j+1...i) > v
        //因为i的当前正在考察的位置，所以为开区间
        int j = left;
        for (int i = left + 1; i <= right; i++) {
            if (arr[i] < v) {
                j++;
                SortTestHelper.swap(arr, j, i);
            }
        }
        SortTestHelper.swap(arr, j, left);
        return j;
    }

    //双路快排
    private static int partition2(int[] arr, int left, int right) {
        //优化2
        // 随机在arr[l...r]的范围中, 选择一个数值作为标定点pivot
        SortTestHelper.swap(arr, left, (int) (Math.random() * (right - left + 1)) + left);
        int v = arr[left];

        ////arr[left+1...j) <= v   arr[j...i] => v
        int i = left + 1, j = right;
        while (true) {
            while (i <= right && arr[i] < v) {
                i++;
            }
            while (j >= left + 1 && arr[j] > v) {
                j--;
            }
            if (i > j) {
                break;
            }
            SortTestHelper.swap(arr, j, i);
            i++;
            j--;
        }
        SortTestHelper.swap(arr, j, left);

        return j;
    }

    public static int findKth(int[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            return -1;
        }
        return findKth(arr, k, 0, arr.length - 1);
    }

    public static int findKth(int[] arr, int k, int low, int high) {

        if (low == high)
            return arr[low];

        int p = partition2(arr, low, high);
        if (p < k) {
            return findKth(arr, k, p + 1, high);
        } else if (p > k) {
            return findKth(arr, k, low, p - 1);
        } else{
            return arr[p];
        }
    }
}

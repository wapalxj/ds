package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter3_sort_advance.merge_sort;


import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.InsertionSort;
import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.SortTestHelper;

import java.util.Arrays;

/**
 * 归并排序
 */
public class MergeSort {


    public static void main(String[] args) {
        int n = 10;
        int nums[] = SortTestHelper.generateRandomArray(n, 0, n);
        System.out.println(Arrays.toString(nums));
        sort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void sort(int arr[]) {
        int n = arr.length;
        mergeSort(arr, 0, n - 1);
    }

    //递归使用归并排序，堆arr[l...r]范围进行排序
    private static void mergeSort(int arr[], int left, int right) {
//        if (left>=right) {
//            //递归到底的情况
//            return;
//        }

        //优化2：当元素量非常小的时候，转而使用插入排序
        if (right - left <= 15) {
            InsertionSort.insertionSort2(arr, left, right);
            return;
        }

        int mid = left + (right - left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid + 1, right);
        if (arr[mid] > arr[mid + 1]) {
            //优化1: 判断进行优化，已经有序了就不归并了
            merge(arr, left, mid, right);
        }
    }

    //将arr[l...mid]和arr[mid+1...r]两部分进行归并
    public static void merge(int[] arr, int left, int mid, int right) {
        //开辟一个辅助空间aux，
        int[] aux = new int[right - left + 1];
        for (int i = left; i <= right; i++) {
            //aux从0开始，而处理区间是arr[lrft,right]
            aux[i - left] = arr[i];
        }

        int i = left, j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i > mid) {
                //左边越界，则全取右边的数
                arr[k] = aux[j - left];
                j++;
            } else if (j > right) {
                //右边越界，则全取左边的数
                arr[k] = aux[i - left];
                i++;
            } else if (aux[i - left] < aux[j - left]) {
                arr[k] = aux[i - left];
                i++;
            } else {
                arr[k] = aux[j - left];
                j++;
            }
        }
    }
}

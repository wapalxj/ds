package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter4_heap;


import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.SortTestHelper;

/**
 * 原地堆排序
 */
public class HeapSort3 {
    public static void sort(int arr[]) {
        heapSort(arr);
    }

    public static void heapSort(int arr[]) {
        int n = arr.length;
        for (int i = (n - 1) / 2; i >= 0; i--) {
            shiftDown(arr, n, i);
        }
        for (int i = n - 1; i > 0; i--) {
            SortTestHelper.swap(arr, 0, i);
            shiftDown(arr, i, 0);
        }

    }

    //长度为n的数组，i位置元素进行shiftDown
    private static void shiftDown(int[] arr, int n, int i) {
        while (2 * i + 1 < n) {
            int j = 2 * i + 1;//j和i交换位置
            if (j + 1 < n && arr[j + 1] > arr[j]) {
                j += 1;
            }

            if (arr[i] >= arr[j]) {
                break;
            }
            //j和i交换位置
            SortTestHelper.swap(arr, i, j);
            i = j;
        }
    }
}

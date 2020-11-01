package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter4_heap;

import java.util.Arrays;

/**
 * heapify
 */
public class HeapSort2 {

    public static void sort(int arr[]) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        heapSort(array);
    }

    public static void heapSort(Integer arr[]) {
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = 0; i < n; i++) {
            arr[i] = maxHeap.extractMax();
        }
    }
}

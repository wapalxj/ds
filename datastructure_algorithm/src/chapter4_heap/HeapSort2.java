package chapter4_heap;

import java.util.Arrays;

/**
 * heapify
 */
public class HeapSort2 {
    public static void main(String[] args) {
        int[] arr=new int[]{5,1,2,4,6};
        sort(arr);
    }
    public static void sort(int arr[]) {
        Integer[] array = new Integer[arr.length];
        for (int i = 0; i < arr.length; i++) {
            array[i] = arr[i];
        }
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }

    public static void heapSort(Integer arr[]) {
        int n = arr.length;
        MaxHeap<Integer> maxHeap = new MaxHeap<>(arr);
        for (int i = n-1; i >=0; i--) {
            arr[i] = maxHeap.extractMax();
        }
    }
}

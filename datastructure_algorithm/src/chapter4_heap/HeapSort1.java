package chapter4_heap;

import chapter2_sort_basic.SortTestHelper;

import java.util.Arrays;

public class HeapSort1 {

    public static void main(String[] args) {
        int[] arr=new int[]{5,1,2,4,6};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
    public static void sort(int arr[]){
        heapSort(arr);
    }
    public static void heapSort(int arr[]){
        int n=arr.length;
        MaxHeap<Integer> maxHeap=new MaxHeap<>(n);
        for (int i = 0; i < n; i++) {
            maxHeap.insert(arr[i]);
        }
        for (int i = n-1; i >=0; i--) {
            arr[i]=maxHeap.extractMax();
        }
    }


}

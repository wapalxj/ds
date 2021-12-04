package algorithms.liuyubobobo.datastructure_algorithm.src.chapter4_heap;

import java.util.Arrays;

public class HeapSort1 {

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

    public static void main(String[] args) {
        int []arr={49,38,65,97,76,13,27,49};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

}

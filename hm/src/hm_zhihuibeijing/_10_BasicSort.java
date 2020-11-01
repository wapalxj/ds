package hm_zhihuibeijing;

import java.util.Arrays;

public class _10_BasicSort {
    public static void main(String[] args) {
        int arr[]={3,7,5,1,4};
//        int arr[]={6,7,8,9,11};
//        int arr[] = {6, 5, 4, 3, 1};
//        bubbleSort2(arr);
        selectionSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void insertionSort(int[] arr) {
        int len = arr.length;
        for (int i = 0; i < len - 1; i++) {
            int p = arr[i + 1];
            int j;
            for (j = i + 1; j >= 0; j--) {
                if (arr[j - 1] > p) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = p;
        }
    }

    //hm
    public static void insertionSort2(int[] arr) {
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int p = arr[i];
            int j;
            for (j = i - 1; j >= 0; j--) {
                if (arr[j] > p) {
                    arr[j + 1] = arr[j];
                } else {
                    break;
                }
            }
            arr[j + 1] = p;
        }
    }

    public static void bubbleSort(int[] arr) {
        int len = arr.length;
        boolean swap = false;
        for (int i = 0; i < len - 1; i++) {
            swap = false;
            for (int j = 0; j < len - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!swap) {
                return;
            }
        }
    }

    //hm
    public static void bubbleSort2(int[] arr) {
        int len = arr.length;
        boolean swap = false;
        for (int i = len - 1; i > 0; i--) {
            swap = false;
            for (int j = 0; j < i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap = true;
                    swap(arr, j, j + 1);
                }
            }
            if (!swap) {
                return;
            }
        }
    }


    //hm
    public static void selectionSort(int[] arr){
        int len = arr.length;
        for (int i = 0; i < len-1; i++) {
            int min=i;
            for (int j = i+1; j < len; j++) {
                if (arr[j]<arr[min]) {
                    min=j;
                }
            }
            if (min !=i) {
                swap(arr,i,min);
            }

        }
    }


    private static void swap(int[] arr, int j, int i) {
        int temp = arr[j];
        arr[j] = arr[i];
        arr[i] = temp;
    }
}

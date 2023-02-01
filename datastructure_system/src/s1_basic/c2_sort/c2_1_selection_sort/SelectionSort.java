package s1_basic.c2_sort.c2_1_selection_sort;

import lb.Generator;
import lb.utils.PrintUtils;
import lb.utils.SortTest;
import lb.utils.SwapUtils;

/**
 * SelectionSort
 */
public class SelectionSort {
    private SelectionSort() {
    }

    public static void main(String[] args) {
//        int[] len={10000,100000};
//        for (int n : len) {
//            Integer[] arr = Generator.generateRandomArray(n, 1, 100000000);
//            SortTest.sortTestOnly(new SortTest.Sortable<Integer>() {
//                @Override
//                public Integer[] sort() {
//                    selectionSort2(arr);
//                    return arr;
//                }
//            });
//        }

        Integer[] arr = Generator.generateRandomArray(6, 1, 30);
        PrintUtils.printArr(arr);
        SortTest.sortTest(new SortTest.Sortable<Integer>() {
            @Override
            public Integer[] sort() {
                selectionSort2(arr);
                return arr;
            }
        });


    }

    /**
     * 7 13 3 18 8 19
     *
     * 从左往右排
     * 循环不变量:a(i..n]未排序，a[0..i]已排序
     * O(n*n)
     */
    public static void selectionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            SwapUtils.swap(arr, i, minIndex);
        }
    }

    /**
     *
     * 从右往左排
     * 循环不变量:a[0..i)未排序，a[i..n]已排序
     */
    public static void selectionSort2(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) >= 0) {
                    maxIndex = j;
                }
            }
            SwapUtils.swap(arr, i, maxIndex);
        }
    }


}

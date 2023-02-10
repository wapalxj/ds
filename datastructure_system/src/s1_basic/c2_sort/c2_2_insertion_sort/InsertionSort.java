package s1_basic.c2_sort.c2_2_insertion_sort;

import lb.Generator;
import lb.utils.PrintUtils;
import lb.utils.SortTest;
import lb.utils.SwapUtils;

/**
 * InsertionSort
 * O(n*n)
 *
 * 对于有序数组，O(n)
 *
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void main(String[] args) {
//        int[] len = {10000, 100000};
//        for (int n : len) {
//            Integer[] arr = Generator.generateRandomArray(n, 1, 100000000);
//            SortTest.sortTestOnly(new SortTest.Sortable<Integer>() {
//                @Override
//                public Integer[] sort() {
//                    insertionSort(arr);
//                    return arr;
//                }
//            });
//        }

        Integer[] arr = Generator.generateRandomArray(100, 1, 1000);
        PrintUtils.printArr(arr);
        SortTest.sortTest(new SortTest.Sortable<Integer>() {
            @Override
            public Integer[] sort() {
                insertionSort4(arr);

                return arr;
            }
        });
    }

    /**
     * 7 13 3 18 8 19
     * <p>
     * O(n*n)
     * 从左往右排
     * 循环不变量 a[i..n)未排序
     *
     *
     * 对于有序数组，O(n)
     */
    public static void insertionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j >= 1; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    SwapUtils.swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 7 13 3 18 8 19
     * <p>
     * O(n*n)
     * 从右往左排
     * 循环不变量 a[0..i)未排序
     */
    public static void insertionSort2(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            for (int j = i; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    SwapUtils.swap(arr, j, j + 1);
                } else {
                    break;
                }
            }
        }
    }

    /**
     * 插入排序优化 减少交换次数 从左往右 a[0..i)已排好序
     * 7 13 3 18 8 19
     * 3 7 13 18 8 19
     */
    public static void insertionSort3(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int min = arr[i];
            int j = i;
            for (; j >= 1; j--) {
                if (min < arr[j - 1]) {
                    arr[j] = arr[j - 1];
                } else {
                    break;
                }
            }
            arr[j] = min;
        }
    }

    /**
     * 插入排序优化 减少交换次数 从右往左 a[i..n)已排好序
     * 7 13 3 18 8 19
     * 7 13 3 8 18 19
     */
    public static void insertionSort4(Integer[] arr) {
        for (int i = arr.length - 1; i >= 0; i--) {
            int max = arr[i];
            int j = i;
            for (; j < arr.length - 1; j++) {
                if (max > arr[j + 1]) {
                    arr[j] = arr[j + 1];
                } else {
                    break;
                }
            }
            arr[j] = max;
        }
    }


}

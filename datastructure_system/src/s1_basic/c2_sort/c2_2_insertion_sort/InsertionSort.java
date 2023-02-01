package s1_basic.c2_sort.c2_2_insertion_sort;

import lb.Generator;
import lb.utils.PrintUtils;
import lb.utils.SortTest;
import lb.utils.SwapUtils;

/**
 * InsertionSort
 *
 *
 */
public class InsertionSort {
    private InsertionSort() {
    }

    public static void main(String[] args) {
        Integer[] arr=Generator.generateRandomArray(10,1,100);
        PrintUtils.printArr(arr);
        SortTest.sortTest(new SortTest.Sortable<Integer>() {
            @Override
            public Integer[] sort() {
                insertionSort(arr);

                return arr;
            }
        });
        System.out.println("sdsadsad");
    }
    /**
     * 7 13 3 18 8 19
     *
     * O(n*n)
     *
     */
    public static void insertionSort(Integer[] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j]<arr[j-1]){
                    SwapUtils.swap(arr,j,j-1);
                }
            }
        }
    }


}

package algorithms.liuyubobobo.datastructure_algorithm.src.chapter3_sort_advance;


import algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic.SortTestHelper;

public class TestSort {
    public static void main(String[] args) {
        // 测试排序算法辅助函数
        int N = 1_000_000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, 10);
//        int[] arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        int[] arr1=SortTestHelper.copyInArray(arr);
        int[] arr2=SortTestHelper.copyInArray(arr);
        System.out.println("归并排序：");
        SortTestHelper.testSort("chapter3_sort_advance.merge_sort.MergeSort", arr);

        System.out.println("快速排序：");
        SortTestHelper.testSort("chapter3_sort_advance.quick_sort.QuickSort", arr1);

        System.out.println("3路快速排序：");
        SortTestHelper.testSort("chapter3_sort_advance.quick_sort.QuickSort3Ways", arr2);

    }
}

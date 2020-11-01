package byd.algorithms.liuyubobobo.datastructure_algorithm.src.chapter2_sort_basic;

public class TestSort {
    public static void main(String[] args) {
//        int nums[] = {10, 8, 9, 7, 6, 5, 9, 3, 2, 1};
        int n=10000;
        int nums[] = SortTestHelper.generateRandomArray(n,0,n);
//        selectionSort(nums);
//        System.out.println(Arrays.toString(nums));


        // 测试排序算法辅助函数
        int N = 50000;
        int[] arr = SortTestHelper.generateRandomArray(N, 0, N);
//        int[] arr = SortTestHelper.generateNearlyOrderedArray(N, 100);
        int[] arr1=SortTestHelper.copyInArray(arr);
        int[] arr2=SortTestHelper.copyInArray(arr);
        int[] arr3=SortTestHelper.copyInArray(arr);
        int[] arr4=SortTestHelper.copyInArray(arr);
        int[] arr5=SortTestHelper.copyInArray(arr);
        System.out.println("冒泡排序：");
        SortTestHelper.testSort("chapter2_sort_basic.BubbleSort", arr);
        System.out.println("选择排序：");
        SortTestHelper.testSort("chapter2_sort_basic.SelectionSort", arr1);
        System.out.println("插入排序：");
        SortTestHelper.testSort("chapter2_sort_basic.InsertionSort", arr2);
        System.out.println("希尔排序：");
        SortTestHelper.testSort("chapter2_sort_basic.ShellSort", arr3);

        System.out.println("归并排序：");
        SortTestHelper.testSort("chapter3_sort_advance.merge_sort.MergeSort", arr4);

        System.out.println("快速排序：");
        SortTestHelper.testSort("chapter3_sort_advance.quick_sort.QuickSort", arr5);
    }
}

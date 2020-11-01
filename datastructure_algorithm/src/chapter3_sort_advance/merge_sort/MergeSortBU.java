package chapter3_sort_advance.merge_sort;

/**
 * 自底向上的归并排序
 */
public class MergeSortBU {

    public static void mergeSortBU(int arr[]) {
        int n = arr.length;
        for (int sz = 1; sz <= n; sz += sz) {
            //先看1个元素，再看2个，4个，8个

            for (int i = 0; i + sz < n; i += sz + sz) {
                //对arr[i...i+sz-1] 和 arr[i+sz...i+2*sz-1]进行归并
                //min是为了防止越界
                MergeSort.merge(arr, i, i + sz - 1,
                        Integer.min(i + sz + sz - 1, n - 1));
            }
        }
    }
}

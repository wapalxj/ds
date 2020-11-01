package chapter2_sort_basic;

public class InsertionSort {

    public static void sort(int[] nums) {
        insertionSort2(nums);
    }

    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            //寻找arr[i]的合适插入位置
//            for (int j = i; j > 0; j--) {
//                if (arr[j]<arr[j-1]) {
            //和前一个元素比较
            //可以提前结束循环，所以性能比选择排序好
//                    SortTestHelper.swap(arr,j,j-1);
//                }else {
//                    break;
//                }
//            }


            //简化的写法
            for (int j = i; j > 0 && arr[j] < arr[j - 1]; j--) {
                SortTestHelper.swap(arr, j, j - 1);
            }
        }
    }

    //优化：不进行交换
    public static void insertionSort2(int arr[]) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            //寻找arr[i]的合适插入位置
            int e = arr[i];
            int j;//元素e应该插入的位置
            for (j = i; j > 0 && arr[j - 1] > e; j--) {
                arr[j] = arr[j - 1];
            }
            arr[j] = e;
        }
    }

    // 对arr[l...r]的区间使用InsertionSort排序
    public static void insertionSort2(int[] arr, int l, int r){
        assert l >= 0 && l <= r && r < arr.length;
        for( int i = l + 1 ; i <= r ; i ++ ){
            int e = arr[i];
            int j = i;
            for( ; j > 0 && arr[j-1]>e ; j--)
                arr[j] = arr[j-1];
            arr[j] = e;
        }
    }
}

package algorithms;

import java.util.Arrays;

/**
 * Created by mu.guihai on 2017/10/24.
 */
public class QuickSort {
    public static void main(String[] args) {
        int n = 10;
        int[] a = {6, 1, 2, 7, 9, 3, 4, 5, 10, 8};
//        int[] a = {49, 38, 65, 97, 76, 13, 27, 49};
//        int[] a = {1,0,0,0,0,0,0,0,0,0,0,0};
//        int a[] = SortTestHelper.generateRandomArray(n, 0, n);
        quickSort(a);

        System.out.println(Arrays.toString(a));
        System.out.println(findKth(a, 3));
    }

    private static void quickSort(int[] a) {
        if (a == null) {
            throw new RuntimeException("arg is null");
        }
        sort(0, a.length - 1, a);
    }

    private static void sort(int low, int high, int[] a) {
        if (low < high) {
            int pivotloc = partition3(low, high, a);
            sort(low, pivotloc - 1, a);
            sort(pivotloc + 1, high, a);
        }
    }

    //数据结构2
    private static int partition3(int low, int high, int[] a) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            a[low] = a[high];
            while (low < high && a[low] <= temp) {
                low++;
            }
            a[high] = a[low];
        }
        a[low] = temp;
        System.out.println(Arrays.toString(a));
        return low;
    }

    //数据结构1
    private static int partition2(int low, int high, int[] a) {
        int temp = a[low];
        while (low < high) {
            while (low < high && a[high] >= temp) {
                high--;
            }
            swap(a, low, high);
            while (low < high && a[low] <= temp) {
                low++;
            }
            swap(a, low, high);
        }
        System.out.println(Arrays.toString(a));
        return low;
    }

    //啊哈算法
    private static int partition(int low, int high, int[] a) {
//        int i, j, pivot;
//        pivot = a[low];
//        i = low;
//        j = high;
//        while (i < j) {
//            while (a[j] >= pivot && i < j) {
//                j--;
//            }
//            while (a[i] <= pivot && i < j) {
//                i++;
//            }
//            if (i < j) {
//                swap(a,i,j);
//            }
//        }
////        a[low] = a[i];
////        a[i] = pivot;
//        swap(a,low,i);
//        System.out.println(Arrays.toString(a));
//        return i;

        int left, pivot;
        left = low;
        pivot = a[low];
        while (low < high) {
            while (a[high] >= pivot && low < high) {
                high--;
            }
            while (a[low] <=pivot && low < high) {
                low++;
            }
            if (low < high) {
                swap(a, low, high);
            }
        }
        swap(a, low, left);
        System.out.println(Arrays.toString(a));
        return low;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int findKth(int[] arr, int k) {
        if (k < 0 || k >= arr.length) {
            return -1;
        }
        return findKth(arr, k, 0, arr.length - 1);
    }

    public static int findKth(int[] arr, int k, int low, int high) {

        if (low == high)
            return arr[low];

        int p = partition2( low, high,arr);
        if (p < k) {
            return findKth(arr, k, p + 1, high);
        } else if (p > k) {
            return findKth(arr, k, low, p - 1);
        } else {
            return arr[p];
        }
    }
}

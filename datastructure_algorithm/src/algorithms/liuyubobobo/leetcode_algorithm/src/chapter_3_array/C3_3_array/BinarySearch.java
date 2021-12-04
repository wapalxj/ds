package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_3_array;

/**
 * 二分法查找
 */
public class BinarySearch {

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i <= 10; i++) {
//            System.out.println(binarySearch(arr, i));
            System.out.println(binarySearchWithRecursin(arr, i));
        }
    }

    //边界为闭区间
    //在arr[l...h]中查找
    public static int binarySearch(int[] arr, int e) {
        int low = 0;
        int high = arr.length - 1;
        int mid;
        //在arr[l...h]中查找
        //arr[n..n]也合法
        while (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == e) {
                return mid;
            } else if (e < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    //边界为开区间
    //在arr[l...h）中查找
    public static int binarySearch2(int[] arr, int e) {
        int low = 0;
        int high = arr.length;
        int mid;
        //在arr[l...h）中查找
        //arr[n..n）不合法
        while (low < high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == e) {
                return mid;
            } else if (e < arr[mid]) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    /**
     * 递归
     * <p>
     * 边界为闭区间
     * 在arr[l...h]中查找
     */
    public static int binarySearchWithRecursin(int[] arr, int e) {
        return binarySearchWithRecursin(arr, e, 0, arr.length - 1);
    }

    private static int binarySearchWithRecursin(int[] arr, int e, int low, int high) {
        int mid;
        if (low <= high) {
            mid = low + (high - low) / 2;
            if (arr[mid] == e) {
                return mid;
            } else if (e < arr[mid]) {
                return binarySearchWithRecursin(arr, e, low, mid - 1);
            } else {
                return binarySearchWithRecursin(arr, e, mid + 1, high);
            }
        }
        return -1;
    }
}

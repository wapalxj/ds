package byd.algorithms;

public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        int position = binarySearch(nums, 7);
        System.out.println(position);
    }

    public static int binarySearch(int arr[], int e) {
        int n = arr.length-1;
//        return binarySearch(arr, 0, n, e);
        return binarySearchWithRecursion(arr, 0, n, e);
    }

    private static int binarySearch(int[] arr, int low, int high, int e) {
        while (low <= high) {
            int mid = low + (high - low) / 2;
            System.out.println(arr[mid]);
            if (arr[mid] == e) {
                return mid;
            } else if (arr[mid] > e) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchWithRecursion(int[] arr, int low, int high, int e) {
        if (low <= high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] == e) {
                return mid;
            } else if (arr[mid] > e) {
                return binarySearchWithRecursion(arr,low,mid - 1,e);
            } else {
                return binarySearchWithRecursion(arr,mid + 1,high,e);
            }
        }
        return -1;
    }
}
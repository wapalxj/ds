package chapter_5_binary_search;


/**
 * 二分查找法
 */
public class BinarySearch {


    public static void main(String[] args) {
        int[] arr = {1, 3, 4, 5,5, 7, 9, 10};
        int index = binarySearch(arr, 5);
        System.out.println(index);
    }

    public static int binarySearch(int arr[], int e) {
        int n = arr.length;
        //在arr[l...r]中查找e
        int l = 0, r = n - 1;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (arr[mid] == e) {
                return mid;
            }
            if (e < arr[mid]) {
                //在arr[l...mid-1]中寻找
                r = mid - 1;
            } else {
                //在arr[mid+1...r]中寻找
                l = mid + 1;
            }
        }
        return -1;
    }
}

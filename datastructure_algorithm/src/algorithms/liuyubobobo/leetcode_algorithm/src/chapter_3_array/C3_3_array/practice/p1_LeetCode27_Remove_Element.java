package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_3_array.practice;

public class p1_LeetCode27_Remove_Element {
    public static int removeElement(int[] nums, int val) {
        int len=nums.length;
        int k=0;//[0,k)之间不包括val
        for (int i = 0; i < len; i++) {
            if (nums[i] !=val) {
                if (k != i) {
                    swap(nums,k,i);
                }
                k++;
            }
        }

        return k;
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static void main(String[] args) {
//        int[] arr = {0,1,2,3,4, 5, 6};
//        int[] arr = {1, 0, 2, 3, 0, 0, 4, 5, 6};
        int[] arr = {1, 0, 2, 3, 0, 4, 5, 0, 6};
        int newLen=removeElement(arr,0);
        for (int i = 0; i < newLen; i++) {
            System.out.print(arr[i]+" ");
        }

    }
}

package chapter_3_array.C3_5_Sort_Colors.practice;

/**
 * 在未排序的数组中找到第 k 个最大的元素
 *
 * 利用快速排序partition思想
 */
public class p2_LeetCode215_find_Kth_element_in_array {

    static class Solution {
        public static int findKthLargest(int[] nums, int k) {
            if (k < 1 || k > nums.length) {
                return -1;
            }

            int left = 0;
            int right = nums.length - 1;
            int pos = partition(nums, left, right);
            while (true) {
                if (pos == nums.length - k) {
                    //已经找到
                    break;
                } else if (pos < nums.length - k) {
                    //在右边寻找
                    pos = partition(nums, pos + 1, right);
                } else {
                    //在左边寻找
                    pos = partition(nums, left, pos - 1);
                }
            }
            return nums[pos];
        }


        public static int partition(int[] nums, int left, int right) {
            int p = nums[left];
            while (left < right) {
                while (left < right && nums[right] >= p) {
                    right--;
                }
                nums[left] = nums[right];
                while (left < right && nums[left] <= p) {
                    left++;
                }
                nums[right] = nums[left];
            }
            nums[left] = p;
            return left;
        }

        public static void main(String[] args) {
            int[] nums={3,2,1,5,6,4};
            int p=findKthLargest(nums,1);
            System.out.println(p);
        }
    }


}

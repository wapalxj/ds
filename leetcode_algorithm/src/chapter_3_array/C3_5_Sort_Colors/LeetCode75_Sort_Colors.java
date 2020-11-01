package chapter_3_array.C3_5_Sort_Colors;

import java.util.Arrays;

public class LeetCode75_Sort_Colors {
    static class Solution {

        //直观解法--计数排序
        //时间复杂度:O(n)
        //空间复杂度:O(1)
        public static void sortColors(int[] nums) {
            int[] count = {0, 0, 0};//存放0,1,2三个元素的频率
            for (int i = 0; i < nums.length; i++) {
                count[nums[i]]++;
            }

            int index = 0;
//            for (int i = 0; i < count[0]; i++) {
//                nums[index++] = 0;
//            }
//            for (int i = 0; i < count[1]; i++) {
//                nums[index++] = 1;
//            }
//            for (int i = 0; i < count[2]; i++) {
//                nums[index++] = 2;
//            }

            for (int i = 0; i < count.length; i++) {
                for (int j = 0; j < count[i]; j++) {
                    nums[index++] = i;
                }
            }
        }


        //三路快排partition思路
        //时间复杂度:O(n)
        //空间复杂度:O(1)
        public static void sortColors2(int[] nums) {
            int zero = -1;//nums[0...zero]==0,初始区间为[0,-1],即为空
            int two = nums.length;//nums[two...n-1]==2,初始区间为[n,n-1],即为空
            for (int i = 0; i < two;) {
                if (nums[i] == 1) {
                    i++;
                } else if (nums[i] == 2) {
                    two--;
                    swap(nums, i, two);
                } else if (nums[i] == 0) {
                    zero++;
                    swap(nums, zero, i);
                    i++;
                }
            }
        }

        //交换
        private static void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }

        public static void main(String[] args) {
            int nums[]={2,0,2,1,1,0};
            sortColors(nums);
//            sortColors2(nums);
            System.out.println(Arrays.toString(nums));
        }
    }
}

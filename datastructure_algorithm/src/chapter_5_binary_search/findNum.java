package chapter_5_binary_search;

import java.util.Collections;
import java.util.Random;

/**
 * 0123456789九个数随机拿出一个，如何判断拿出的是哪一个（最简洁的方法）
 *
 * 二分查找对不对?
 */
public class findNum {
    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int num = nums[new Random().nextInt(nums.length)];
        System.out.println("拿出的是:"+num);

        System.out.println("我猜拿出的是:"+binarySearch(num, nums));


    }

    //
    private static int binarySearch(int num, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int count=0;
        while (left <= right) {
            System.out.println("我第:"+(++count)+"次猜");
            int mid = left + (right - left) / 2;
            if (num == nums[mid]) {
                return num;
            }else if (num >nums[mid]) {
                left=mid+1;
            }else {
                right=mid-1;
            }
        }
        return 0;
    }
}

package chapter_4_find.C4_8_binarysearch_sort;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

/**
 * 	时间复杂度
 * 	(set的底层相关，如果是二叉搜索树，则每次查询为logk)
 * 	 O(nlogk)
 * 空间复杂度: O(k)
 */
public class LeetCode_220_Contains_Duplicate3 {

    public  static boolean containsNearbyAlmostDuplicate(int[] nums, int k, int t) {
        TreeSet<Long> record = new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {

            Long temp = record.ceiling((long) nums[i] - (long) t);

            if (temp != null && temp <= (long) nums[i] + (long) t){
                return true;
            }
            record.add((long) nums[i]);
            if (record.size() == k + 1) {
                //保持窗口大小最多为k
                //移除窗口最左边的元素
                record.remove((long)nums[i-k]);
            }

        }
        return false;
    }
    private static void printBool(boolean b){
        System.out.println(b ? "True" : "False");
    }

    public static void main(String[] args) {
        int[] nums = {-2147483648, -2147483647};
        int k = 3;
        int t = 3;
        printBool(containsNearbyAlmostDuplicate(nums, k, t));
    }
}

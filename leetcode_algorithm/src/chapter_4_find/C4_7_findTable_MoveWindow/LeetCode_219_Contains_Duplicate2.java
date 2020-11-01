package chapter_4_find.C4_7_findTable_MoveWindow;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * // 时间复杂度: O(n)
 * // 空间复杂度: O(k)
 *
 * //滑动窗口+查找表
 */
public class LeetCode_219_Contains_Duplicate2 {

    static class Solution {
        public boolean containsNearbyDuplicate(int[] nums, int k) {
            Set<Integer> record = new HashSet<>();
            for (int i = 0; i < nums.length; i++) {
                if (record.contains(nums[i])) {
                    return true;
                } else {
                    record.add(nums[i]);
                    if (record.size() == k + 1) {
                        //保持窗口大小最多为k
                        //移除窗口最左边的元素
                        record.remove(nums[i - k]);
                    }
                }
            }
            return false;
        }

        public static void main(String[] args) {
        }
    }
}

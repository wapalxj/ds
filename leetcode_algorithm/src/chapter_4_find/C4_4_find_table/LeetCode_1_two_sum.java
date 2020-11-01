package chapter_4_find.C4_4_find_table;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * O(n)
 */
public class LeetCode_1_two_sum {


    static class Solution {
        public int[] twoSum(int[] nums, int target) {
            //key---元素，value---索引
            Map<Integer, Integer> record = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int complement = target - nums[i];
                if (record.containsKey(complement)) {
                    int res[] = {i, record.get(complement)};
                    return res;
                } else {
                    record.put(nums[i], i);
                }
            }

            throw new IllegalArgumentException("no result");
        }

        public static int[] twoSum2(int[] nums, int target) {
            Map<Integer,Integer> map=new HashMap<>();
            int[] res=new int[2];
            for(int i=0;i<nums.length;i++){
                int complement=target-nums[i];
                if(map.containsKey(complement)){
                    res[0]=map.get(complement);
                    res[1]=i;
                    return res;
                }else{
                    map.put(nums[i],i);
                }
            }

            res[0]=res[1]=-1;
            return res;
        }

        public static void main(String[] args) {
           int[] nums = {2, 15, 11, 7};
           System.out.println(Arrays.toString(twoSum2(nums,9)));
        }
    }
}

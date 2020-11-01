package chapter_4_find.C4_4_find_table.practice;

import java.util.*;

public class p1_LeetCode15_3_sum {

    /// Using two pointer technique
/// Time Complexity: O(n^2)
/// Space Complexity: O(n)
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> res=new ArrayList<>();

        int index = 0;
        while( index < nums.length ){
            if( nums[index] > 0 )
                break;

            int bindex = index + 1;
            int cindex = nums.length-1;
            while( bindex < cindex) {
                if (nums[bindex] + nums[cindex] == -nums[index]) {
                    List<Integer> list=new ArrayList<>();
                    list.add(nums[index]);
                    list.add(nums[bindex]);
                    list.add(nums[cindex]);
                    res.add(list);
                    // continue to look for other pairs
                    bindex = next_num_index( nums, bindex );
                    cindex = pre_num_index( nums, cindex);
                }
                else if (nums[bindex] + nums[cindex] < -nums[index])
                    bindex = next_num_index( nums, bindex );
                else //nums[bindex] + nums[cindex] > -nums[index]
                    cindex = pre_num_index( nums, cindex);
            }

            index = next_num_index( nums , index );
        }
        return res;
    }

    private static int next_num_index(int[] nums, int cur) {

        for (int i = cur + 1; i < nums.length; i++)
            if (nums[i] != nums[cur])
                return i;
        return nums.length;
    }

    private static int pre_num_index(int[] nums, int cur) {

        for (int i = cur - 1; i >= 0; i--)
            if (nums[i] != nums[cur])
                return i;
        return -1;
    }


    /**
     *
     * 使用set  to store all the numbers
     *
     * Time Complexity: O(n^2)
     * Space Complexity: O(n)
     *
     * @param nums
     * @return
     */

    //
    public static List<List<Integer>> threeSum2(int[] nums) {

        Map<Integer,Integer> counter=new HashMap<>();
        for(int i = 0 ; i < nums.length ; i ++){
            if (!counter.containsKey(nums[i])) {
                counter.put(nums[i],1);
            }else {
                counter.put(nums[i],counter.get(nums[i])+1);
            }
        }


        List<List<Integer>> res=new ArrayList<>();

        //出现了3次0
        if(counter.get(0)>= 3){
            List<Integer> list=new ArrayList<>();
            list.add(0);
            list.add(0);
            list.add(0);
            res.add(list);
        }


        // Remove duplication
        Arrays.sort(nums);
        Set<Integer> set=new TreeSet<>();
        for (int i = 0; i < nums.length; i++) {
            set.add(nums[i]);
        }
        List<Integer> newNums=new ArrayList<>();
        newNums.addAll(set);


        for(int i = 0 ; i < newNums.size() ; i ++)
            for(int j = i + 1 ; j < newNums.size() ; j ++){

                if(newNums.get(i) * 2 + newNums.get(j) == 0 && counter.get(newNums.get(i)) >= 2){
                    List<Integer> list=new ArrayList<>();
                    list.add(newNums.get(i));
                    list.add(newNums.get(i));
                    list.add(newNums.get(j));
                    res.add(list);
                }
                if(newNums.get(i) + newNums.get(j) * 2 == 0 && counter.get(newNums.get(i)) >= 2){
                    List<Integer> list=new ArrayList<>();
                    list.add(newNums.get(i));
                    list.add(newNums.get(j));
                    list.add(newNums.get(j));
                    res.add(list);
                }

                int c = 0 - newNums.get(i) - newNums.get(j);
                if(c > newNums.get(j) && counter.containsKey(c)){
                    List<Integer> list=new ArrayList<>();
                    list.add(newNums.get(i));
                    list.add(newNums.get(j));
                    list.add(c);
                    res.add(list);
                }
            }

        return res;
    }


    public static void main(String[] args) {
        int[] nums1 = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> res = threeSum(nums1);
        for (int i = 0; i < res.size(); i++) {
            for (int j = 0; j < res.get(i).size(); j++){
                System.out.print(res.get(i).get(j)+" ");
            }
            System.out.println();
        }

    }
}

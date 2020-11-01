package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_4_find.C4_5_find_table2;

import java.util.HashMap;
import java.util.Map;

public class LeetCode_454_two_sum2 {

   static class Solution {
        public static int fourSumCount(int[] A, int[] B, int[] C, int[] D) {
            Map<Integer,Integer> record=new HashMap<>();
            for (int i = 0; i < C.length; i++) {
                for (int j = 0; j < D.length; j++) {
                    int temp=C[i]+D[j];
                    if (record.containsKey(temp)) {
                        //将C+D的每一种可能放入查找表
                        record.put(temp,record.get(temp)+1);
                    }else {
                        record.put(temp,1);
                    }
                }
            }


            int res=0;
            for (int i = 0; i < A.length; i++) {
                for (int j = 0; j < B.length; j++) {
                    int temp=0-A[i]-B[j];
                    if (record.containsKey(temp)) {
                        res+=record.get(temp);
                    }
                }
            }

            return res;
        }

       public static void main(String[] args) {
           int[] A = {1, 2};
           int[] B = {-2,-1};
           int[] C = {-1, 2};
           int[] D = {0, 2};

           System.out.println(fourSumCount(A,B,C,D));
       }
    }
}

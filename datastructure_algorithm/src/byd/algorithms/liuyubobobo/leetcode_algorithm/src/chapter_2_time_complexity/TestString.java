package byd.algorithms.liuyubobobo.leetcode_algorithm.src.chapter_2_time_complexity;

public class TestString {
    public static void main(String[] args) {
        String s;

        for (int i = 0; i < 10; i++) {
            int n= (int) Math.pow(10,i);
            long startTime=System.currentTimeMillis();
            int sum=0;
            for (int j = 0; j < n; j++) {
                sum+=j;
            }
            long endTime=System.currentTimeMillis();

            System.out.println("sum = " + sum);
            System.out.println("10^"+i+"---time---->"+(endTime-startTime));
        }
    }



}

package chapter_4_find.C4_1_set_map.practice;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * 编写一个算法来判断一个数是不是“快乐数”。
 *
 * 一个“快乐数”定义为：对于一个正整数，每一次将该数替换为它每个位置上的数字的平方和，然后重复这个过程直到这个数变为 1，也可能是无限循环但始终变不到 1。如果可以变为 1，那么这个数就是快乐数。
 *
 * 示例:
 *
 * 输入: 19
 * 输出: true
 * 解释:
 * 12 + 92 = 82
 * 82 + 22 = 68
 * 62 + 82 = 100
 * 12 + 02 + 02 = 1
 */
public class p2_LeetCode202_happy_number {

    public static boolean isHappy(int n) {
        //记录计算过程中出现的结果，重复出现则说明是死循环
        List<Integer> process=new ArrayList<>();
        return isHappy(n,process);
    }
    private static boolean isHappy(int n,List<Integer> process) {
        List<Integer> nums=new ArrayList<>();
        while (n !=0) {
            nums.add(n % 10);
            n=n/10;
        }

        int sum=0;
        for (int i = 0; i < nums.size(); i++) {
            sum+=Math.pow(nums.get(i),2);
        }

        System.out.println(sum);
        if (sum != 1) {
            if (process.contains(sum)) {
                //重复出现则说明是死循环
                return false;
            }
            process.add(sum);
            return isHappy(sum,process);
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.println(isHappy(2));
    }
}

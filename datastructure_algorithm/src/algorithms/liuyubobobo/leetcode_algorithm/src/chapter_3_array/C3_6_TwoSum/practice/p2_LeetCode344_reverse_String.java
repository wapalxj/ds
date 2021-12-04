package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_6_TwoSum.practice;

public class p2_LeetCode344_reverse_String {
    public static String reverseString(String s) {
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = s.length()-1; i >=0 ; i--) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static String reverseString2(String s) {
        char[] chars=s.toCharArray();
        int len=chars.length;
        for (int i = 0; i<chars.length/2 ; i++) {
            swap(chars,i,len-1-i);
        }
        return new String(chars);
    }

    //交换
    private static void swap(char[] nums, int i, int j) {
        char temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public static void main(String[] args) {
        String s="A man, a plan, a canal: Panama";
        System.out.println(reverseString(s));
        System.out.println(reverseString2(s));
    }
}

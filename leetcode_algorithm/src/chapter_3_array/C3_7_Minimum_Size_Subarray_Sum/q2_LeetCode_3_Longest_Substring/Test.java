package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q2_LeetCode_3_Longest_Substring;

public class Test {


    public static int lengthOfLongestSubstring(String s) {
        int freq[] =new int[256];
        int left=0,right=-1;
        int res=1;

        while (left<s.length()){
            if (right+1<s.length() && freq[s.charAt(1+right)]==0) {
                freq[s.charAt(++right)]++;
            }else {
                freq[s.charAt(left++)]--;
            }

            res=Math.max(res,(right-left+1));
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}

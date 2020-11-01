package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.q2_LeetCode_3_Longest_Substring;

public class LeetCode3_Longest_Substring {
}

class Solution {

    // 滑动窗口
    // 时间复杂度: O(len(s))
    // 空间复杂度: O(len(charset))
    public static int lengthOfLongestSubstring(String s) {
        int freq[] = new int[256];//字符频率存储
        int left = 0, right = -1;//滑动窗口s[l...r]
        int res = 0;

        // 整个循环从 l == 0; r == -1 这个空窗口开始
        // 到l == s.size(); r == s.size()-1 这个空窗口截止
        // 在每次循环里逐渐改变窗口, 维护freq, 并记录当前窗口中是否找到了一个新的最优值
        while (left < s.length()) {
            if (right + 1 < s.length() && freq[s.charAt(right + 1)] == 0) {
                freq[s.charAt(++right)]++;
            } else {
                freq[s.charAt(left++)]--;
            }
            System.out.println(left+"------"+right);
            res = Math.max(res, right - left + 1);
        }

        return res;
    }

    public static void main(String[] args) {
//        System.out.println(lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(lengthOfLongestSubstring("bbbbbbbb"));
        System.out.println(lengthOfLongestSubstring("pwwkew"));
    }
}
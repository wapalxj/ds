package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class P1_L438_ {

    private static int[] findAnagrams(String s, String p) {
        int[] freq = new int[26];//存频率
        int[] freqP = new int[26];//存p频率
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        int l = 0;
        int r = -1;
        List<Integer> list = new ArrayList<>();

        while (r + 1 < s.length()) {
            r++;
            freq[s.charAt(r) - 'a']++;
            if (r - l + 1 > p.length()) {
                freq[s.charAt(l++) - 'a']--;
            }


            if (r - l + 1 == p.length() && same(freq, freqP)) {
                list.add(l);
            }

        }
        int[] res = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;

    }

    private static boolean same(int[] freq, int[] freqP) {
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != freqP[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findAnagrams2("cbaebabacd", "abc")));
        System.out.println(Arrays.toString(findAnagrams2("abab", "ba")));
    }

    private static int[] findAnagrams2(String s, String p) {
        int freq[] = new int[26];//当前窗口的频率
        int freqP[] = new int[26];//p的频率
        for (int i = 0; i < p.length(); i++) {
            freqP[p.charAt(i) - 'a']++;
        }

        int left = 0;
        int right = -1;
        List<Integer> res = new ArrayList<>();
        while (left < s.length()) {
            if (right + 1 < s.length() && (right - left + 1) < p.length()) {
                freq[s.charAt(++right) - 'a']++;
            } else {
                freq[s.charAt(left++) - 'a']--;
            }

            if ((right - left + 1) == p.length()) {
                if (same(freq, freqP)) {
                    res.add(left);
                }
            }

        }

        int resInt[] = new int[res.size()];
        for (int i = 0; i < res.size(); i++) {
            resInt[i] = res.get(i);
        }

        return resInt;
    }
}

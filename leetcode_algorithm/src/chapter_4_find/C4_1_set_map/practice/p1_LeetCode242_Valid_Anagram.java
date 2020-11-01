package chapter_4_find.C4_1_set_map.practice;

import java.util.HashMap;
import java.util.Map;

public class p1_LeetCode242_Valid_Anagram {
    public static boolean isAnagram(String s, String t) {
        boolean res = false;
        if (s.length() != t.length()) {
            return res;
        }

        //map存储字符出现的频率
        Map<Character, Integer> table = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (table.containsKey(c)) {
                table.put(c, table.get(c) + 1);
            } else {
                table.put(c, 1);
            }
        }

        for (int i = 0; i < t.length(); i++) {
            char c = t.charAt(i);
            if (table.containsKey(c)) {
                table.put(c, table.get(c) - 1);
                if (table.get(c) == 0) {
                    table.remove(c);
                }
            }
        }
        //如果map为空，则true
        res = table.size() == 0;
        return res;
    }

    public static void main(String[] args) {
        String s = "anagram";
        String t = "nagaram";
        System.out.println(isAnagram(s, t));

        s = "rat";
        t = "caR";
        System.out.println(isAnagram(s, t));
    }
}

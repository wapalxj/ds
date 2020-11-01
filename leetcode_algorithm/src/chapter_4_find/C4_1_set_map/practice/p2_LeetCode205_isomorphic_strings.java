package chapter_4_find.C4_1_set_map.practice;

import java.util.HashMap;
import java.util.Map;

public class p2_LeetCode205_isomorphic_strings {
    /**
     * hashmap版本，
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> keys = new HashMap<>();


        for (int i = 0; i < s.length(); i++) {
            if (!keys.containsKey(s.charAt(i)) && !keys.containsValue(t.charAt(i))) {
                //哈希表不存在s----key并且t----value没有被映射
                keys.put(s.charAt(i), t.charAt(i));
            } else if (!keys.containsKey(s.charAt(i)) || keys.get(s.charAt(i)) != t.charAt(i)) {
                //不存在key,则value被已经被其他key映射
                //存在key，则必须对应当前的value
                return false;
            }
        }
        return true;
    }

    /**
     * 数组版本，速度更快
     * @param s
     * @param t
     * @return
     */
    public static boolean isIsomorphic2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] keys = new int[256];//key---value
        int[] values = new int[256];//value---key
//        Map<Character, Character> keys = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            if (keys[s.charAt(i)] == 0 && values[t.charAt(i)] == 0) {
                //哈希表不存在s----key并且t----value没有被映射
                keys[s.charAt(i)] = t.charAt(i);
                values[t.charAt(i)] = s.charAt(i);
            } else if (keys[s.charAt(i)] == 0 ||
                    keys[s.charAt(i)] != t.charAt(i) ||
                    values[t.charAt(i)] != s.charAt(i)) {
                //不存在key,则value被已经被其他key映射
                //存在key，则必须对应当前的value
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        String S = "egg";
        String T = "add";
        System.out.println(isIsomorphic(S, T));

        S = "foo";
        T = "bar";
        System.out.println(isIsomorphic(S, T));

        S = "paper";
        T = "title";
        System.out.println(isIsomorphic(S, T));

        S = "ab";
        T = "aa";
        System.out.println(isIsomorphic(S, T));

    }
}

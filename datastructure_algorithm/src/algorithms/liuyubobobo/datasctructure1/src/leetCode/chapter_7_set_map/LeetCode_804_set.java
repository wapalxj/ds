package algorithms.liuyubobobo.datasctructure1.src.leetCode.chapter_7_set_map;

import java.util.TreeSet;

public class LeetCode_804_set {

    static class Solution {
        public static int uniqueMorseRepresentations(String[] words) {
            String[] codes = {".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..", "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--.."};
            TreeSet<String> set = new TreeSet<>();
            for (String word : words) {
                //遍历每个单词
                StringBuilder res = new StringBuilder();
                for (int i = 0; i < word.length(); i++) {
                    res.append(codes[word.charAt(i) - 'a']);
                }
                //添加每个单词的摩斯码
                set.add(res.toString());
            }
            return set.size();
        }

        public static void main(String[] args) {
            String[] words = {"gin", "zen", "gig", "msg"};
            System.out.println(uniqueMorseRepresentations(words));
        }
    }
}



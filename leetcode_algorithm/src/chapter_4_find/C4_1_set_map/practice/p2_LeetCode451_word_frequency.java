package chapter_4_find.C4_1_set_map.practice;


import java.util.*;

public class p2_LeetCode451_word_frequency {

    public static String frequencySort(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }

        //统计频率
        Map<Character, Integer> map = new TreeMap<>();
        for (int i = 0; i < s.length(); i++) {
            if (map.containsKey(s.charAt(i))) {
                map.put(s.charAt(i), map.get(s.charAt(i)) + 1);
            } else {
                map.put(s.charAt(i), 1);
            }
        }

        //使用优先级队列
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return map.get(o2) - map.get(o1);
            }
        });

        priorityQueue.addAll(map.keySet());

        //拼接结果字符串
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.remove();
            for (int i = 0; i < map.get(c); i++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    //数组版本
    public static String frequencySort2(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        //统计频率
        int[] freq = new int[256];
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i)]++;
        }
        //使用优先级队列
        PriorityQueue<Character> priorityQueue = new PriorityQueue<>(new Comparator<Character>() {
            @Override
            public int compare(Character o1, Character o2) {
                return freq[o2] - freq[o1];
            }
        });

        for (int i = 0; i < freq.length; i++) {
            if (freq[i]>0) {
                priorityQueue.add((char)i);
            }
        }
        //拼接结果字符串
        StringBuilder res = new StringBuilder();
        while (!priorityQueue.isEmpty()) {
            char c = priorityQueue.remove();
            for (int i = 0; i < freq[c]; i++) {
                res.append(c);
            }
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "abab";
        System.out.println(frequencySort2(s));
        s = "tree";
        System.out.println(frequencySort2(s));
        s = "eert";
        System.out.println(frequencySort2(s));
        s = "bbAa";
        System.out.println(frequencySort2(s));
    }
}

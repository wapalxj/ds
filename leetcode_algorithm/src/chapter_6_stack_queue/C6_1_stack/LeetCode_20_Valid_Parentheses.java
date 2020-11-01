package chapter_6_stack_queue.C6_1_stack;

import chapter_5_linkedlist.ListNode;

import java.util.LinkedList;
import java.util.Stack;

public class LeetCode_20_Valid_Parentheses {

    static class Solution {
        public static boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (c == '(' || c == '[' || c == '{') {
                    stack.push(c);
                } else {
                    if (stack.isEmpty()) {
                        return false;
                    }
                    char top = stack.pop();
                    char match;
                    if (c == ')') {
                        match = '(';
                    } else if (c == ']') {
                        match = '[';
                    } else if (c == '}') {
                        match = '{';
                    } else {
                        return false;
                    }
                    if (top != match) {
                        return false;
                    }
                }
            }

            if (stack.isEmpty()) {
                return true;
            }
            return false;
        }

        public static void main(String[] args) {
            String str="()";
            System.out.println(isValid(str));
        }
    }
}

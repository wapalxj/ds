package algorithms.liuyubobobo.datasctructure1.src.chapter2_stack.stack;

public class Solution {

    public static void main(String[] args) {
        String s="([])]";
        System.out.println(isValid(s));
    }

    public static boolean isValid(String s) {
//        Stack<Character> stack = new Stack<>();
        ArrayStack<Character> stack = new ArrayStack<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '[' || c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                char topChar = stack.pop();
                if (c == ')' && topChar != '(') {
                    return false;
                }
                if (c == ']' && topChar != '[') {
                    return false;
                }
                if (c == '}' && topChar != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
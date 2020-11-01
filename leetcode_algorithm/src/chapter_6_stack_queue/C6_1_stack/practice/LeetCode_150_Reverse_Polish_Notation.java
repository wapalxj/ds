package chapter_6_stack_queue.C6_1_stack.practice;


import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class LeetCode_150_Reverse_Polish_Notation {

    public static int evalRPN(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];
            if (isNumeric00(c)) {
                stack.push(c);
            } else {
                String num2 = stack.pop();
                String num1 = stack.pop();
                if (c.equals("+")) {
                    stack.push(String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2)));
                } else if (c.equals("-")) {
                    stack.push(String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2)));
                } else if (c.equals("*")) {
                    stack.push(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)));
                } else if (c.equals("/")) {
                    stack.push(String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2)));
                }

                System.out.println("----" + stack.peek());
            }
        }
        return Integer.parseInt(stack.pop());
    }

    //    public static boolean isNumeric(String str){
//        Pattern pattern = Pattern.compile("[0-9]*");
//        Matcher isNum = pattern.matcher(str);
//        if( !isNum.matches() ){
//            return false;
//        }
//        return true;
//    }
    public static boolean isNumeric(String str) {

        for (int i = 0; i < str.length(); i++) {
            if (i == 0 && str.charAt(i) == '-' && str.length() > 1) {
                continue;
            }

            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    public static boolean isNumeric00(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }


    public static int evalRPN1111111111111(String[] tokens) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < tokens.length; i++) {
            String c = tokens[i];

            if (c.equals("+")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(String.valueOf(Integer.parseInt(num1) + Integer.parseInt(num2)));
            } else if (c.equals("-")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(String.valueOf(Integer.parseInt(num1) - Integer.parseInt(num2)));
            } else if (c.equals("*")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(String.valueOf(Integer.parseInt(num1) * Integer.parseInt(num2)));
            } else if (c.equals("/")) {
                String num2 = stack.pop();
                String num1 = stack.pop();
                stack.push(String.valueOf(Integer.parseInt(num1) / Integer.parseInt(num2)));
            }else {
                int num=Integer.parseInt(c);
                stack.push(String.valueOf(num));
            }

        }
        return Integer.parseInt(stack.pop());
    }

    public static void main(String[] args) {
        String[] tokens = {"2", "1", "+", "3", "*"};
//        tokens= new String[]{"4", "13", "5", "/", "+"}/;
        tokens = new String[]{"10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"};

        System.out.println(evalRPN1111111111111(tokens));

//        System.out.println(isNumeric("-11"));
    }
}

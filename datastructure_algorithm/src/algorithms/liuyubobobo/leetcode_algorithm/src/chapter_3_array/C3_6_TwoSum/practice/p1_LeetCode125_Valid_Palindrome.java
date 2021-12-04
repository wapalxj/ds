package algorithms.liuyubobobo.leetcode_algorithm.src.chapter_3_array.C3_6_TwoSum.practice;


public class p1_LeetCode125_Valid_Palindrome {
    public static boolean isPalindrome(String s) {
        int len = s.length();
        int left = 0;
        int right = len - 1;
        while (left < right) {
            ////////////left不是字母和数字，则向后走//////////////
            char leftChar = s.charAt(left);
            boolean alphanumeric =alphanumeric(leftChar);
            while (left < right && !alphanumeric) {
                left++;
                leftChar = s.charAt(left);
                alphanumeric = alphanumeric(leftChar);
            }

            ////////////right不是字母和数字，则向前走//////////////
            char rightChar = s.charAt(right);
            alphanumeric = alphanumeric(rightChar);
            while (left < right && !alphanumeric) {
                right--;
                rightChar = s.charAt(right);
                alphanumeric =alphanumeric(rightChar);
            }

            if (left >= right || Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) {
                break;
            }
            left++;
            right--;
        }
        if (left < right) {
            return false;
        }

        return true;
    }

    private static boolean alphanumeric(char c){
        return (c >= 'A' && c <= 'Z') || (c >= 'a' && c <= 'z') || (c >= '0' && c <= '9');
    }
    public static void main(String[] args) {
//        String s = "A man, a plan, a canal: Panama";
        String s = "race a car";
        System.out.println(isPalindrome(s));
    }
}

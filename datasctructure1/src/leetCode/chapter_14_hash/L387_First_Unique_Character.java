package leetCode.chapter_14_hash;

public class L387_First_Unique_Character {

    static class Solution {
        public int firstUniqChar(String s) {
            //数组类型可以假定只包含小写字母
            //那就使用int[26]存储每个字符的频率
            //a[0]表示a出现的频率
            int[] freq = new int[26];
            for (int i = 0; i < s.length(); i++) {
                freq[s.charAt(i) - 'a']++;
            }
            for (int i = 0; i < s.length(); i++) {
                if (freq[s.charAt(i) - 'a'] == 1) {
                    return i;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        String s = "loveleetcode";
        System.out.println(solution.firstUniqChar(s));
    }
}

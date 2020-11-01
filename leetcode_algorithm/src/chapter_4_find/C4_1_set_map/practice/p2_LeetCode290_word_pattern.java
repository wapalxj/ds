package chapter_4_find.C4_1_set_map.practice;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一种 pattern(模式) 和一个字符串 str ，判断 str 是否遵循相同的模式。
 *
 * 这里的遵循指完全匹配，例如， pattern 里的每个字母和字符串 str 中的每个非空单词之间存在着双向连接的对应模式。
 *
 * 示例1:
 *
 * 输入: pattern = "abba", str = "dog cat cat dog"
 * 输出: true
 * 示例 2:
 *
 * 输入:pattern = "abba", str = "dog cat cat fish"
 * 输出: false
 * 示例 3:
 *
 * 输入: pattern = "aaaa", str = "dog cat cat dog"
 * 输出: false
 * 示例 4:
 *
 * 输入: pattern = "abba", str = "dog dog dog dog"
 * 输出: false
 * 说明:
 * 你可以假设 pattern 只包含小写字母， str 包含了由单个空格分隔的小写字母。
 */
public class p2_LeetCode290_word_pattern {

    /**
     * 和205题完全一样的
     * @param pattern
     * @param str
     * @return
     */
    public boolean wordPattern(String pattern, String str) {
        String[] strA=str.split(" ");
        if(pattern.length()!=strA.length){
            return false;
        }

        Map<Character,String> map=new HashMap<>();

        for(int i=0;i<pattern.length();i++){
            if(!map.containsKey(pattern.charAt(i)) && !map.containsValue(strA[i])){
                map.put(pattern.charAt(i),strA[i]);
            }else if(!map.containsKey(pattern.charAt(i)) || !map.get(pattern.charAt(i)).equals(strA[i])){
                return false;
            }
        }

        return true;
    }
}

package algorithms.liuyubobobo;

import java.util.ArrayList;
import java.util.Scanner;

public class TestScanner {
    public static void main(String[] args) {
        Scanner scanner= new Scanner(System.in);
        ArrayList<String> words =new ArrayList<>();
        if (scanner.hasNextLine()) {
            String contents = scanner.useDelimiter("\\A").nextLine();
            int start = firstCharacterIndex(contents, 0);
            for (int i = start + 1; i <= contents.length(); )
                if (i == contents.length() || !Character.isLetter(contents.charAt(i))) {
                    String word = contents.substring(start, i).toLowerCase();
                    words.add(word);
                    start = firstCharacterIndex(contents, i);
                    i = start + 1;
                } else
                    i++;
        }
        System.out.println(words);
//        String str=scanner.useDelimiter("\\A").nextLine();
//        System.out.println(str);
    }

    // 寻找字符串s中，从start的位置开始的第一个字母字符的位置
    private static int firstCharacterIndex(String s, int start) {

        for (int i = start; i < s.length(); i++)
            if (Character.isLetter(s.charAt(i)))
                return i;
        return s.length();
    }
}
package algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by mu.guihai on 2018/3/1.
 */
public class Combination {
    public static void combiantion(char chs[]) {
        if (chs == null || chs.length == 0) {
            return;
        }
        List<Character> list = new ArrayList();
        for (int i = 1; i <= chs.length; i++) {
            combine(chs, 0, i, list);
        }
    }

    //从字符数组中第begin个字符开始挑选number个字符加入list中
    public static void combine(char[] cs, int begin, int number, List<Character> list) {
        if (number == 0) {
            System.out.println(list.toString());
            return;
        }
        if (begin == cs.length) {
            return;
        }

        list.add(cs[begin]);
        combine(cs, begin + 1, number - 1, list);
        list.remove((Character) cs[begin]);
        combine(cs, begin + 1, number, list);
    }

    public static void main(String args[]) {
        char chs[] = {'1', '2', '3'};
        combiantion(chs);
//        com(chs);
    }

    public static void com(char chs[]){
        for (int num = 1; num <= chs.length; num++) {
            char [] temp=new char[num];
            for (int j = 0; j < chs.length; j++) {
                for (int k = 0; k <chs.length-num; k++) {
                    temp[k]=chs[j];
                    System.out.println(Arrays.toString(temp));
                }
//                temp[i-1]=chs[j];
//                System.out.println(Arrays.toString(temp));
            }
        }
    }
}

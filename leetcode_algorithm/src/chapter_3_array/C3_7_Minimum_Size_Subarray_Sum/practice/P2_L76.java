package chapter_3_array.C3_7_Minimum_Size_Subarray_Sum.practice;

public class P2_L76 {
    public static String minWindow(String s, String t) {
        int freq[]=new int[256];
        int freT[]=new int[256];
        for (int i = 0; i < t.length(); i++) {
            freT[t.charAt(i)-'A']++;
        }
        int left=0;
        int right=-1;
        int [] res=new int[]{0,Integer.MAX_VALUE};
        while (left<s.length()){
            //如果没有找到，即继续前进
            if (!same(freq,freT) && right+1<s.length()) {
                freq[s.charAt(++right)-'A']++;
            }else {
                freq[s.charAt(left++)-'A']--;
            }

            //如果找到,记录left和right
            if (same(freq,freT)) {
                if (right-left<res[1]-res[0]) {
                    res[0]=left;
                    res[1]=right;
                }
            }

        }
        if (res[1] -res[0]==Integer.MAX_VALUE) {
            return "";
        }
        StringBuilder stringBuilder=new StringBuilder();
        for (int i = res[0]; i <=res[1]; i++) {
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();
    }

    public static boolean same(int freq[],int freqT[]){
        for (int i = 0; i < freqT.length; i++) {
            if (freqT[i]!=0 && freqT[i]>freq[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String S="ADOBECODEBANC";
        String T="ABC";
        System.out.println(minWindow(S,T));

        S="bbaac";
        T="aba";
        System.out.println(minWindow(S,T));


    }
}

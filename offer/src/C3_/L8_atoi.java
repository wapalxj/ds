package C3_;

public class L8_atoi {

    public static int myAtoi(String str) {
        int i=0;//index
        int sign=1;//符号
        int base=0;

        if(str==null || str.length()==0){
            return 0;
        }
        while(i<str.length() && str.charAt(i)==' '){
            i++;
        }

        if(i<str.length() && str.charAt(i)=='-'){
            sign=-1;
            i++;
        }else if(i<str.length() && str.charAt(i)=='+'){
            i++;
        }

        while(i<str.length() && str.charAt(i)>='0' && str.charAt(i)<='9'){

            if(base>Integer.MAX_VALUE/10||(base==Integer.MAX_VALUE/10 && (str.charAt(i)-'0')>Integer.MAX_VALUE%10)){

                return (sign==1)? Integer.MAX_VALUE:Integer.MIN_VALUE;

            }

            base=base*10+ (str.charAt(i)-'0');
            i++;
        }

        base=base*sign;

        return base;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("-42"));
    }
}

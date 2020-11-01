package C3_;

public class L17_print_1_To_MaxOfDigits2 {

    public static void print_1_To_MaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];

        for (int i = 0; i < 10; i++) {
            number[0]= (char) (i+'0');
            withRecursion( number, n,0);
        }
    }

    private static void withRecursion(char[] number, int n,int index) {
        if (index ==number.length-1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index+1]= (char) (i+'0');
            withRecursion( number, n,index+1);
        }

    }


    private static void printNumber(char[] number) {
        boolean isBegining0=true;
        int length=number.length;

        for (int i = 0; i < length; i++) {
            if (isBegining0 && number[i] != '0') {
                //去除最头部的0
                isBegining0=false;
            }
            if (!isBegining0) {
                System.out.print(number[i]);
            }
        }

        System.out.println();
    }


    public static void main(String[] args) {
        print_1_To_MaxOfDigits(2);
    }
}

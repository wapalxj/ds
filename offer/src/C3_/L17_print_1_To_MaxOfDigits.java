package C3_;

public class L17_print_1_To_MaxOfDigits {

    public static void print_1_To_MaxOfDigits(int n) {
        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        memset(number,'n');
        while (!increament(number)) {
            printNumber(number);
        }
    }

    private static void memset(char[] number, char n) {
        for (int i = 0; i < number.length; i++) {
            number[i]='0';
        }
    }

    private static boolean increament(char[] number) {
        boolean isOverFlow = false;
        int takeOver = 0;
        int length = number.length;

        for (int i = length - 1; i >= 0; i--) {
            int sum = number[i] - '0' + takeOver;
            if (i == length - 1) {
                //原数字+1
                sum++;
            }
            if (sum >= 10) {
                //进位
                if (i == 0) {
                    //超过指定的N位数
                    isOverFlow = true;
                } else {
                    sum -= 10;
                    takeOver = 1;//进位
                    number[i] = (char) ('0' + sum);//前一位设为0
                }
            } else {
                //最后的结果
                number[i] = (char) ('0' + sum);
                break;
            }
        }

        return isOverFlow;
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

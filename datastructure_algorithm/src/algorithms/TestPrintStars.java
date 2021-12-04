package algorithms;

public class TestPrintStars {
    public static void main(String[] args) {
//        printStars1(7);
//        printStars6(5);
//        printStarsWithRecursion(7);
        printStars7(5);
    }


    //递归实现
    public static void printStarsWithRecursion(int n) {
        printStarsWithRecursion((n-1)/2,1,n);
    }

    //递归实现
    private static void printStarsWithRecursion(int spaceCount, int starCount,int n) {
        if (starCount >= n) {
            printString(spaceCount,starCount);
            return;
        }
        printString(spaceCount,starCount);
        printStarsWithRecursion(spaceCount-1,starCount+2,n);
        printString(spaceCount,starCount);

    }

    //递归实现
    private static void printString(int spaceCount, int starCount) {
        for (int x = 0; x < spaceCount; x++) {
            System.out.print(" ");
        }
        for (int x = 0; x < starCount; x++) {
            System.out.print("*");
        }
        System.out.println();
    }



    public static void printStars7(int n) {
        int half=(n+1)/2;
        int sum=half+1;//对称以前，行数与开始打印*列数之和
        int temp;
        for (int i = 1; i <= n; i++) {
            if (i > half) {
                temp=i-(i-half)*2;//行数大于对称轴的   赋值成对称于对称轴的行数
            }else {
                temp=i;//行数不大于对称轴的 使用原行数
            }

            for (int j = 1; j <= n; j++) {
                if (j <sum-temp || j>n-(half-temp)) {
                    System.out.print(" ");
                }else {
                    System.out.print("*");
                }
            }
            System.out.println();
        }
    }
    public static void printStars6(int n) {
        int N = n;
        for (int i = -N/2; i < N/2+1; i++) {
            for (int x = 0; x < Math.abs(i); x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < N-2*Math.abs(i); x++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    //线性规划
    public static void printStars5(int n) {
        int N = n;
        int half = N / 2;
        for (int y = 0; y < N; y++) {
            for (int x = 0; x < N; x++) {
                if (y >= -x + half && y >= x - half && y <= x + half && y <= -x + 3 * half) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }

            System.out.println();

        }
    }

    public static void printStars4(int n) {
        int N = n;

        int index;
        int line;
        int start;
        int end;
        for (int i = 0; i <= N * N; i++) {

            index = i % N;
            line = i / N;
            start = Math.abs(N / 2 - line);
            end = N - 1 - start;
            if (index >= start && index <= end) {
                System.out.print("*");
            } else {
                System.out.print(" ");
            }

            if (index == N - 1) {
                System.out.println();
            }

        }
    }


    public static void printStars3(int n) {
        int N = n;
        int sNum = 1;
        boolean swap = false;
        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < (N - sNum) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < sNum; j++) {
                System.out.print("*");
            }
            if (sNum < N && !swap) {
                sNum += 2;
            } else {
                swap = true;
                sNum -= 2;
            }

            System.out.println();
        }
    }
    public static void printStars22(int n) {
        int N = n;
        for (int i = 0; i <N; i++) {
            int spaceCount=N/2-i;
            if (spaceCount<0) {
                spaceCount=-spaceCount;
            }
            for (int x = 0; x < spaceCount; x++) {
                System.out.print(" ");
            }
            for (int x = 0; x < N-2*spaceCount; x++) {
                System.out.print("*");
            }
            System.out.println();

        }
    }
    public static void printStars2(int n) {
        int N = n;
        for (int i = 1; i <= N; i++) {
            int starCount = 2 * i - 1;
            if (starCount>N) {
                starCount=N-(starCount-N);
            }

            for (int j = 0; j < (N - starCount) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < starCount; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    public static void printStars1(int n) {
        int N = n;
        for (int i = 1; i <= N; i += 2) {
            for (int j = 0; j < (N - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = N - 2; i >= 1; i -= 2) {
            for (int j = 0; j < (N - i) / 2; j++) {
                System.out.print(" ");
            }
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
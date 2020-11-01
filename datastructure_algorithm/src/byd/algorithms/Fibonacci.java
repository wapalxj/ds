package byd.algorithms;

public class Fibonacci {
    /**
     * 最常想到的 递归
     *
     * @param n
     * @return
     */
    private static long compute(int n) {
        if (n > 1)
            return compute(n - 2) + compute(n - 1);
        return n;
    }

    /**
     * 稍微优化了的递归，减少了调用次数
     *
     * @param n
     * @return
     */
    private static long computeWithLoop(int n) {


        if (n > 1) {
            long result = 1;
            do {

                result += computeWithLoop(n - 2);
                n--;

            } while (n > 1);

            return result;
        }

        return n;

    }


    //索引从0开始
    private static long fibonacci(int n) {
        int[] f = new int[n + 1];
        f[0] = 0;
        if (n > 0) {
            f[1] = 1;
            for (int i = 2; i < f.length; i++) {
                f[i] = f[i - 2] + f[i - 1];
            }
        }
        return f[f.length - 1];
    }

    //索引从1开始
    private static long fibonacci2(int n) {
        int[] f = new int[n];
        f[0] = 0;
        if (n > 1) {
            f[1] = 1;
            for (int i = 2; i < f.length; i++) {
                f[i] = f[i - 2] + f[i - 1];
            }
        }
        return f[f.length - 1];
    }

    private static int fibonacci3(int n) {
        int pre = 0;
        int post = 1;
        int result = 0;
        if (n <= 0) {
            result = 0;
        }
        if (n == 1) {
            result = pre + post;
        }
        while (n > 1) {
            result = pre + post;
            pre = post;
            post = result;
            n--;
        }

        return result;
    }


    /**
     * O(n)
     */
    private static int fibonacci4(int n) {
        if (n == 0)
            return 0;
        matrix ans = new matrix(1, 0, 0, 1); // 单位阵
        matrix m = new matrix(1, 1, 1, 0);
        while (n > 0) {
            if ((n & 1) > 0)
                ans = multi(ans, m);
            m = multi(m, m);
            n >>= 1;
        }
        return ans.b;
    }

    static class matrix {
        int a, b;
        int c, d;

        public matrix(int a, int b, int c, int d) {
            this.a = a;
            this.b = b;
            this.c = c;
            this.d = d;
        }
    }

    private static matrix multi(matrix x, matrix y) { // 2*2 矩阵乘法
        int newA = x.a * y.a + x.b * y.c;
        int newB = x.a * y.b + x.b * y.d;
        int newC = x.c * y.a + x.d * y.c;
        int newD = x.c * y.b + x.d * y.d;

        return new matrix(newA, newB, newC, newD);
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }

        System.out.println();
        for (int i = 1; i < 11; i++) {
            System.out.print(fibonacci2(i) + " ");
        }

        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci3(i) + " ");
        }
        System.out.println();
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci4(i) + " ");
        }
    }


}
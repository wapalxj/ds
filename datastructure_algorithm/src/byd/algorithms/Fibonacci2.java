package byd.algorithms;

public class Fibonacci2 {
    private static int fibonacci(int n) {
        if (n < 0) {
            throw new IllegalArgumentException("n is err");
        }
        int[] fib = new int[n + 1];
        fib[0] = 0;
        if (n >= 1) {
            fib[1] = 1;
            for (int i = 2; i < fib.length; i++) {
                fib[i] = fib[i - 1] + fib[i - 2];
            }
        }
        return fib[n];
    }

    public static void main(String[] args) {
        for (int i = 0; i < 11; i++) {
            System.out.print(fibonacci(i) + " ");
        }
    }


}
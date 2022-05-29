package BaekJoon.DP;

import java.util.Scanner;

public class OneMake {
    static int count = 0;
    static int[] dp;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();

        dp = new int[N + 1];
        int value = function(N);
        System.out.println(count);
    }

    private static int function(int n) {
        if (n == 1) {
            return 0;
        }
        if (n % 3 == 0) {
            return Math.min(function(n / 3), function(n - 1)) + 1;
        } else if (n % 2 == 0) {
            return Math.min(function(n / 2), function(n - 1)) + 1;
        } else {
            return function(n - 1) + 1;
        }
    }
}

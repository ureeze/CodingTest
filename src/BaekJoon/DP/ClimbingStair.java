package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClimbingStair {
    static int[] dp;
    static int[] score;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        score = new int[N + 1];
        for (int i = 1; i < N + 1; i++) {
            score[i] = Integer.parseInt(br.readLine());
        }
        dp = new int[N + 1];
        dp[0] = 0;
        dp[1] = score[1];
        dp[2] = score[1] + score[2];

        int max = function(N);
        System.out.println(max);
    }

    private static int function(int n) {
        if (n == 0) {
            return dp[0];
        } else if (n == 1) {
            return dp[1];
        } else if (n == 2) {
            return dp[2];
        }
        return dp[n] = Math.max(function(n - 3) + score[n - 1], function(n - 2)) + score[n];
    }
}

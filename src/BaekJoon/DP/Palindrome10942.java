package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Palindrome10942 {
    static int n, m;
    static int[] value;
    static boolean[][] dp;
    static StringBuilder result = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        value = new int[n + 1];
        dp = new boolean[n + 1][n + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= n; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        check(value, n);
        m = Integer.parseInt(br.readLine());
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            int num = dp[start][end] == true ? 1 : 0;
            result.append(num).append("\n");
        }
        System.out.println(result);
    }

    private static void check(int[] value, int n) {
        for (int i = 1; i <= n; i++) {
            dp[i][i] = true;
        }
        for (int i = 1; i < n; i++) {
            if (value[i] == value[i + 1]) {
                dp[i][i + 1] = true;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= n - (i - 1); j++) {
                if (value[j] == value[j + (i - 1)] && dp[j + 1][j + i - 2]) {
                    dp[j][j + i - 1] = true;
                }
            }
        }
    }
}
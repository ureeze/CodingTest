package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class ElectricLine2565 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        int[][] a = new int[n][2];
        int[] dp = new int[n];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            a[i][0] = Integer.parseInt(st.nextToken());
            a[i][1] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(a, (o1, o2) -> o1[0] - o2[0]);
        int max = 0;
        for (int i = 0; i < n; i++) {
            dp[i] = 1;
            for (int j = 0; j < i; j++) {
                if (a[i][1] > a[j][1]) {
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }
            max = Math.max(dp[i], max);
        }

        System.out.println(n - max);
    }
}

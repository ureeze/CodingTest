package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class NormalBag12865 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        int[][] items = new int[N + 1][2];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());
            items[i][0] = weight;
            items[i][1] = value;
        }
        Arrays.sort(items, (o1, o2) -> o1[0] - o2[0]);
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 0; i < N + 1; i++) {
            for (int j = 0; j < K + 1; j++) {
                if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (j - items[i][0] >= 0) {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - items[i][0]] + items[i][1]);
                    } else {
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
        }
        System.out.println(dp[N][K]);
    }
}
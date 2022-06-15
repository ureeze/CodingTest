package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class DownHillRoad1520 {
    static int N, K;
    static int[][] map, dp;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        map = new int[N][K];
        dp = new int[N][K];
        for (int i = 0; i < N; i++) {
            Arrays.fill(dp[i], -1);
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < K; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        System.out.println(dfs(0, 0));

    }

    private static int dfs(int x, int y) {
        if (x == N - 1 && y == K - 1) {
            return 1;
        }
        dp[x][y] = 0;
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < N && ny < K && map[x][y] > map[nx][ny]) {
                if (dp[nx][ny] == -1) {
                    dp[x][y] += dfs(nx, ny);
                } else {
                    dp[x][y] += dp[nx][ny];
                }
            }
        }

        return dp[x][y];
    }
}

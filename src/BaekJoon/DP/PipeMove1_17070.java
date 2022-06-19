package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PipeMove1_17070 {
    static int N;
    static int[][] map;
    static int[][][] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        dp = new int[N][N][3]; // 파이프 끝 점이 올 수 있는 경우의 수 ( 0:가로, 1:세로, 2:대각선 )
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dp[0][1][0] = 1;

        for (int i = 0; i < N; i++) {
            for (int j = 2; j < N; j++) {
                //파이프 놓인 모양이 가로인 경우
                if (checkRow(i, j)) {
                    dp[i][j][0] = dp[i][j - 1][0] + dp[i][j - 1][2];
                }

                //파이프 놓인 모양이 세로인 경우
                if (checkCol(i, j)) {
                    dp[i][j][1] = dp[i - 1][j][1] + dp[i - 1][j][2];
                }

                //파이프 놓인 모양이 대각선인 경우
                if (checkDiagonal(i, j)) {
                    dp[i][j][2] = dp[i - 1][j - 1][0] + dp[i - 1][j - 1][1] + dp[i - 1][j - 1][2];
                }

            }
        }


        System.out.println(dp[N - 1][N - 1][0] + dp[N - 1][N - 1][1] + dp[N - 1][N - 1][2]);
    }

    private static boolean checkDiagonal(int x, int y) {
        if (x - 1 < 0 || x - 1 >= N || y - 1 < 0 || y - 1 >= N) {
            return false;
        }

        if (map[x][y] == 1 || map[x - 1][y] == 1 || map[x][y - 1] == 1) {
            return false;
        }

        return true;
    }

    private static boolean checkCol(int x, int y) {
        if (x - 1 < 0 || x - 1 >= N || y < 0 || y >= N) {
            return false;
        }

        if (map[x][y] == 1) {
            return false;
        }

        return true;
    }

    private static boolean checkRow(int x, int y) {
        if (x < 0 || x >= N || y - 1 < 0 || y - 1 >= N) {
            return false;
        }

        if (map[x][y] == 1) {
            return false;
        }

        return true;
    }


}

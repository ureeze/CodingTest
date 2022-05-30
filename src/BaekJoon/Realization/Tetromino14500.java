package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Tetromino14500 {
    static int n;
    static int m;
    static int[][] map;

    static int max;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        map = new int[n][m];
        max = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        boolean[][] visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                visited[i][j] = true;
                dfs(i, j, map[i][j], 1, visited);
                visited[i][j] = false;
                checkShape(i, j);
            }
        }

        System.out.println(max);
    }

    private static void checkShape(int x, int y) {
        // ㅏ
        if (x < n - 2 && y < m - 1)
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y + 1]);

        // ㅓ
        if (x < n - 2 && y > 0)
            max = Math.max(max, map[x][y] + map[x + 1][y] + map[x + 2][y] + map[x + 1][y - 1]);

        // ㅜ
        if (x < n - 1 && y < m - 2)
            max = Math.max(max, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x + 1][y + 1]);

        // ㅗ
        if (x > 0 && y < m - 2)
            max = Math.max(max, map[x][y] + map[x][y + 1] + map[x][y + 2] + map[x - 1][y + 1]);
    }

    private static void dfs(int x, int y, int sum, int depth, boolean[][] visited) {
        if (depth >= 4) {
            max = Math.max(max, sum);
            return;
        }
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny]) {
                visited[nx][ny] = true;
                dfs(nx, ny, sum + map[nx][ny], depth + 1, visited);
                visited[nx][ny] = false;
            }
        }
    }
}

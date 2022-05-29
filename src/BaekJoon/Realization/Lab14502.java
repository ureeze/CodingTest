package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Lab14502 {
    static int N;
    static int M;
    static int[][] map;
    static int[][] cpMap;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int max = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        cpMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0);

        System.out.println(max);
    }

    private static void dfs(int depth) {
        if (depth == 3) {
            bfs();
            return;
        }
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (map[i][j] == 0) {
                    map[i][j] = 1;
                    dfs(depth + 1);
                    map[i][j] = 0;
                }
            }
        }
    }

    private static void bfs() {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                cpMap[i][j] = map[i][j];
            }
        }
        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cpMap[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];
                if (nx >= 0 && nx < N && ny >= 0 && ny < M && cpMap[nx][ny] == 0) {
                    cpMap[nx][ny] = 2;
                    queue.offer(new int[]{nx, ny});
                }
            }
        }
        safe(cpMap);
    }

    private static void safe(int[][] cpMap) {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (cpMap[i][j] == 0) {
                    cnt++;
                }
            }
        }
        max = Math.max(max, cnt);
    }
}

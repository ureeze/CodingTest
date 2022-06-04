package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Immigration16234 {
    static int N, L, R;
    static int[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        int day = 0;
        while (true) {
            visited = new boolean[N][N];
            boolean b = checkUnion();
            day++;
            if (b) {
                break;
            }
        }
        System.out.println(day - 1);
    }

    private static boolean checkUnion() {
        int union = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    bfs(i, j);
                    union++;
                }
            }
        }
        return union == N * N ? true : false;
    }

    private static void bfs(int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        Queue<int[]> queue1 = new LinkedList<>();
        visited[x][y] = true;
        int sum = 0;
        queue.add(new int[]{x, y});
        queue1.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0];
            int cy = arr[1];
            sum += map[cx][cy];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= N || visited[nx][ny]) {
                    continue;
                }
                int diff = Math.abs(map[cx][cy] - map[nx][ny]);
                if (diff >= L && diff <= R) {
                    visited[nx][ny] = true;
                    queue.add(new int[]{nx, ny});
                    queue1.add(new int[]{nx, ny});
                }
            }
        }
        int rePopulation = sum / queue1.size();
        while (!queue1.isEmpty()) {
            int[] xy = queue1.poll();
            map[xy[0]][xy[1]] = rePopulation;
        }
    }
}

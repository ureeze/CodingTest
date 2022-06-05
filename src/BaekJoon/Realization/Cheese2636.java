package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Cheese2636 {
    static int N, M;
    static int[][] map;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        int cheeseCount = 0;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    cheeseCount++;
                }
                map[i][j] = num;
            }
        }
        int day = 0;
        int meltCnt = 0;
        while (true) {
            day++;
            visited = new boolean[N][M];
            meltCnt = bfs(0, 0);
            show();
            cheeseCount -= meltCnt;
            if (cheeseCount == 0) {
                break;
            }
        }
        System.out.println(day);
        System.out.println(meltCnt);
    }

    private static void show() {
        System.out.println("=======================================");
        for (int i = 0; i < N; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private static int bfs(int x, int y) {
        int melt = 0;
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[]{x, y});
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            int cx = arr[0];
            int cy = arr[1];
            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= N || ny >= M || visited[nx][ny]) {
                    continue;
                }
                visited[nx][ny] = true;
                if (map[nx][ny] == 0) {
                    queue.offer(new int[]{nx, ny});
                } else if (map[nx][ny] == 1) {
                    map[nx][ny] = 0;
                    melt++;
                    continue;
                }
            }
        }
        return melt;
    }

    static class Node2636 {
        int x;
        int y;

        public Node2636(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public String toString() {
            return "{" +
                    "x=" + x +
                    ", y=" + y +
                    '}';
        }
    }
}

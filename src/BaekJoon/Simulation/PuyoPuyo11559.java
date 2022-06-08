package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class PuyoPuyo11559 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static char[][] map;
    static boolean[][] visited;
    static int n = 12, m = 6;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        map = new char[n][m];
        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }
        Queue<Puyo> bombQueue;
        int set;
        int result = 0;
        while (true) {
            visited = new boolean[n][m];
            set = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (map[i][j] != '.' && !visited[i][j]) {
                        bombQueue = bfs(i, j, map[i][j]);

                        if (bombQueue.size() >= 4) {
                            set++;
                            while (!bombQueue.isEmpty()) {
                                Puyo node = bombQueue.poll();
                                int x = node.x;
                                int y = node.y;
                                map[x][y] = '.';
                            }
                        }
                    }
                }
            }
            if (set != 0) {
                puyoDown();
                result++;
            } else {
                break;
            }
        }
        System.out.println(result);
    }

    private static void puyoDown() {
        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j < m; j++) {
                if (map[i + 1][j] == '.' && map[i][j] != '.') {
                    int x = i, y = j;
                    while (x != n - 1 && map[x + 1][y] == '.') {
                        map[x + 1][y] = map[x][y];
                        map[x][y] = '.';
                        x++;
                    }
                }
            }

        }

    }

    private static Queue<Puyo> bfs(int x, int y, char c) {
        Queue<Puyo> queue = new LinkedList<>();
        Queue<Puyo> bombQueue = new LinkedList<>();
        queue.offer(new Puyo(x, y));
        bombQueue.offer(new Puyo(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Puyo node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < n && ny < m && !visited[nx][ny] && map[nx][ny] == c) {
                    visited[nx][ny] = true;
                    queue.offer(new Puyo(nx, ny));
                    bombQueue.offer(new Puyo(nx, ny));
                }
            }
        }
        return bombQueue;
    }

    private static void show() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
        System.out.println("=======================");
    }
}

class Puyo {
    int x;
    int y;

    public Puyo(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "{x=" + x +
                ", y=" + y +
                '}';
    }
}
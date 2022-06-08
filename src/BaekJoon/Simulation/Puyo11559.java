package BaekJoon.Simulation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Puyo11559 {
    static char[][] map;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};
    static int bfsCnt;
    static int roundCnt = 0;
    static int n, m;
    static Queue<Node11559> bomb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean[][] visited;
        map = new char[12][6];
        n = map.length;
        m = map[0].length;
        for (int i = 0; i < map.length; i++) {
            String s = br.readLine();
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = s.charAt(j);
            }
        }

        while (true) {
            // 1. 상하좌우4 뿌요 탐색
            bfsCnt = 0;
            for (int i = 0; i < map.length; i++) {
                for (int j = 0; j < map[i].length; j++) {
                    if (map[i][j] != '.') {
                        bomb = new LinkedList<>();
                        visited = new boolean[12][6];
                        bfs(i, j, map[i][j], visited);

                        if (bomb.size() >= 4) {
                            System.out.println(map[i][j]);
                            System.out.println(bomb);
                            bfsCnt++;
                            while (!bomb.isEmpty()) {
                                Node11559 node = bomb.poll();
                                map[node.x][node.y] = '.';
                            }
                        }
                    }
                }
            }
            // 2. 뿌요 내림 또는 종료
            if (bfsCnt != 0) {
                // 뿌요 내림
                roundCnt++;
                down();
            } else {
                // 터트릴 것 없어서 종료
                break;
            }
        }
        System.out.println(roundCnt);
    }

    private static void down() {
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

    private static boolean bfs(int x, int y, char c, boolean[][] visited) {
        Queue<Node11559> queue = new LinkedList<>();
        queue.offer(new Node11559(x, y));
        bomb.offer(new Node11559(x, y));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node11559 node = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = node.x + dx[i];
                int ny = node.y + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }
                if (visited[nx][ny] || map[nx][ny] != c) {
                    continue;
                }
                visited[nx][ny] = true;
                queue.offer(new Node11559(nx, ny));
                bomb.offer(new Node11559(nx, ny));
            }
        }
        show();
        return false;
    }

    private static void show() {
        System.out.println("=======================");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

}

class Node11559 {
    int x;
    int y;

    public Node11559(int x, int y) {
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
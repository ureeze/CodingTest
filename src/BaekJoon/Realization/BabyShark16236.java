package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BabyShark16236 {
    static int cSize = 2;
    static int n;
    static int[][] map;
    static boolean[][] visited;
    static int result = 0;
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int stk = 0;
    static PriorityQueue<Node16236> pq = new PriorityQueue<>((o1, o2) -> {
        if (o1.dist == o2.dist) {
            if (o1.x == o2.x) {
                return o1.y - o2.y;
            } else {
                return o1.x - o2.x;
            }
        } else {
            return o1.dist - o2.dist;
        }
    });

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;
        map = new int[n][n];

        int cx = 0;
        int cy = 0;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 9) {
                    cx = i;
                    cy = j;
                }
                map[i][j] = num;
            }
        }
        map[cx][cy] = 0;
        while (true) {
            bfs(cx, cy);
            if (pq.isEmpty()) {
                break;
            }
            Node16236 node = pq.poll();
            result += node.dist;
            stk++;
            if (stk == cSize) {
                cSize++;
                stk = 0;
            }
            pq.clear();
            map[node.x][node.y] = 0;
            cx = node.x;
            cy = node.y;
        }
        System.out.println(result);
    }


    private static void bfs(int x, int y) {
        Queue<Node16236> queue = new LinkedList<>();
        visited = new boolean[n][n];
        queue.offer(new Node16236(x, y, 0));
        visited[x][y] = true;
        while (!queue.isEmpty()) {
            Node16236 node = queue.poll();
            int cx = node.x;
            int cy = node.y;
            int cDist = node.dist;

            for (int i = 0; i < 4; i++) {
                int nx = cx + dx[i];
                int ny = cy + dy[i];
                if (nx < 0 || ny < 0 || nx >= n || ny >= n) {
                    continue;
                }
                if (visited[nx][ny]) {
                    continue;
                }
                if (map[nx][ny] == 0 || map[nx][ny] == cSize) {
                    visited[nx][ny] = true;
                    queue.offer(new Node16236(nx, ny, cDist + 1));
                } else if (map[nx][ny] > 0 && map[nx][ny] < cSize) {
                    visited[nx][ny] = true;
                    pq.offer(new Node16236(nx, ny, cDist + 1));
                }
            }
        }
    }


}

class Node16236 {
    int x;
    int y;
    int dist;

    public Node16236(int x, int y, int dist) {
        this.x = x;
        this.y = y;
        this.dist = dist;
    }

    @Override
    public String toString() {
        return "Node16236{" +
                "x=" + x +
                ", y=" + y +
                ", dist=" + dist +
                '}';
    }
}

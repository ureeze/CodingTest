package PRO2022_2;

import java.util.Arrays;

public class TEST2 {
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int count = 1;
    static int[] point;

    public int[][] solution(int n, boolean horizontal) {
        int[][] map = new int[n][n];
        int x = 0, y = 0;
        point = new int[]{x, y};
        map[x][y] = count++;
        while (true) {
            int max;
            if (horizontal) {
                max = Math.max(point[0], point[1] + 1);
                map[point[0]][point[1] + 1] = count++;
                dfs(point[0], point[1] + 1, map, max);
                horizontal = false;

            } else {
                max = Math.max(point[0] + 1, point[1]);
                map[point[0] + 1][point[1]] = count++;
                dfs(point[0] + 1, point[1], map, max);
                horizontal = true;

            }
            if (max == n - 1) {
                break;
            }
        }
        return map;
    }

    private void dfs(int x, int y, int[][] map, int max) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map.length && map[nx][ny] == 0) {
                if (nx <= max && ny <= max) {
                    map[nx][ny] = count++;
                    point[0] = nx;
                    point[1] = ny;
                    dfs(nx, ny, map, max);
                }
            }
        }
    }

    public static void main(String[] args) {
        TEST2 t = new TEST2();
//        System.out.println(Arrays.deepToString(t.solution(4, true)));
        System.out.println("==============================");
        System.out.println(Arrays.deepToString(t.solution(5, false)));
    }
}

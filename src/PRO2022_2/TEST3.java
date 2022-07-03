package PRO2022_2;

import java.util.ArrayList;
import java.util.Arrays;

public class TEST3 {
    static boolean[][] visited;
    static int[][] map;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};
    static int depth = 0;

    public int[] solution(int rows, int columns, int[][] lands) {
        map = new int[rows][columns];
        visited = new boolean[rows][columns];
        ArrayList<Integer> list = new ArrayList<>();
        int[] answer = {};

        for (int i = 0; i < lands.length; i++) {
            int x = lands[i][0];
            int y = lands[i][1];
            map[x - 1][y - 1] = 1;
        }
        visited[0][0] = true;
        map[0][0] = 2;
        dfs(0, 0);


        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                if (map[i][j] == 0 && !visited[i][j]) {
                    depth = 1;
                    visited[i][j] = true;
                    dfsHosu(i, j);
                    list.add(depth);
                }
            }
        }

        if (list.isEmpty()) {
            return new int[]{-1, -1};
        } else {
            list.sort(null);
            return new int[]{list.get(0), list.get(list.size() - 1)};
        }
    }

    private void show() {
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }

    private void dfsHosu(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                depth++;
                dfsHosu(nx, ny);
            }
        }
    }

    private void dfs(int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx >= 0 && ny >= 0 && nx < map.length && ny < map[0].length && !visited[nx][ny] && map[nx][ny] == 0) {
                visited[nx][ny] = true;
                map[nx][ny] = 2;
                dfs(nx, ny);
            }
        }
    }

    public static void main(String[] args) {
        TEST3 t = new TEST3();
        System.out.println(Arrays.toString(t.solution(9, 7,
                new int[][]{{2, 2}, {2, 3}, {2, 5}, {3, 2}, {3, 4}, {3, 5}, {3, 6}, {4, 3}, {4, 6}, {5, 2}, {5, 5}, {6, 2}, {6, 3}, {6, 4}, {6, 6}, {7, 2}, {7, 6}, {8, 3}, {8, 4}, {8, 5}})));
    }
}

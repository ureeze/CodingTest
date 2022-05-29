package Programmers.KAKAO_CODE_2017;

import java.util.*;

public class ColoringBook {
    static int depth;
    public int[] solution(int m, int n, int[][] picture) {
        boolean[][] visited = new boolean[m][n];
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        int count = 0;
        ArrayList<Integer> list = new ArrayList<>();


        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && picture[i][j] > 0) {
                    visited[i][j] = true;
                    depth = 1;
                    bfs(i, j, picture, visited, m, n, dx, dy);
                    count++;
                    list.add(depth);
                }
            }
        }
        return new int[]{count, Collections.max(list)};
    }

    private void bfs(int x, int y, int[][] picture, boolean[][] visited, int m, int n, int[] dx, int[] dy ) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] arr = queue.poll();
            for (int i = 0; i < 4; i++) {
                int nx = arr[0] + dx[i];
                int ny = arr[1] + dy[i];

                if (nx >= 0 && ny >= 0 && nx < m && ny < n) {
                    if (picture[nx][ny] == picture[x][y] && !visited[nx][ny]) {
                        visited[nx][ny] = true;
                        depth++;
                        queue.add(new int[]{nx, ny});
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        ColoringBook book = new ColoringBook();
        System.out.println(Arrays.toString(book.solution(6, 4, new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}})));
    }
}

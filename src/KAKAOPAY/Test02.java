package KAKAOPAY;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test02 {
    static int row;
    static int col;

    public int[][] solution(int n, int m, int[][] rectangle) {
        int[][] answer = {};
        ArrayList<int[]> list = new ArrayList<>();
        Arrays.sort(rectangle, (o1, o2) -> o1[0] - o2[0]);
        System.out.println(Arrays.deepToString(rectangle));
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < rectangle.length; i++) {
            for (int j = 0; j < rectangle[i][1]; j++) {
                queue.offer(rectangle[i][0]);
            }
        }
        System.out.println(queue);
        boolean[][] visited = new boolean[m][n];
        row = 0;
        col = 0;
        while (!queue.isEmpty()) {
            int len = queue.poll();
            checkRange(visited, n, m, len);

        }

        return answer;
    }

    private void checkRange(boolean[][] visited, int n, int m, int len) {
        for (int i = row; i < m; i++) {
            for (int j = col; j < n; j++) {
                // 인덱스 범위 검사
                if (col + len > n - 1 || row + len > m - 1) {
                    //범위 초과
//                    System.out.println(len + "범위초과 " + i + "," + j + "]");
                    if (j == n - 1) {
                        col = 0;
                    }
                    continue;
                }
                // 방문 검사
                if (checkArr(visited, n, i, j, len)) {
                    // 삽입 가능
                    insertRect(visited, i, j, len);
                    System.out.println(len + "삽입" + i + "," + j);


                    row = i;
                    col = j + 1;
                    return;
                }
            }
        }
    }

    private void insertRect(boolean[][] visited, int a, int b, int len) {
        for (int i = a; i < a + len; i++) {
            for (int j = b; j < b + len; j++) {
                visited[i][j] = true;
            }
        }
    }

    private boolean checkArr(boolean[][] visited, int n, int a, int b, int len) {
        for (int j = b; j < b + len; j++) {
            if (j >= n && visited[a][j]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Test02 t = new Test02();
        System.out.println(Arrays.deepToString(t.solution(7, 8, new int[][]{{2, 2}, {1, 4}, {3, 2}})));
    }
}

package SSG;

import java.util.ArrayList;

public class TEST4 {
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static int count;

    public String[] solution(int[][] macaron) {
        boolean flag = false;
        ArrayList<int[]> list = new ArrayList<>();
        String[] answer = {};
        int[][] map = new int[7][15];
        for (int i = 0; i < macaron.length; i++) {
            int index = macaron[i][0];
            int color = macaron[i][1];

            checkMap(map, index, color);
            for (int j = 1; j < 7; j++) {
                for (int k = 1; k < 7; k++) {
                    if (map[j][k] != 0) {
                        count = 1;
                        list.clear();
                        dfs(map, j, k, map[j][k], list);
                        if (count >= 3) {
                            //삭제 로직
                            removeMap(map, list);
                            flag = true;
                            break;
                        }
                    }
                }
            }

            //삭제했을경우
            if (flag) {
                //마카롱이동
                moveMap(map);
                //dfs
            }

        }
        return answer;
    }

    private void moveMap(int[][] map) {
        for (int i = 1; i < 7; i++) {
            for (int j = 1; j < 7; j++) {

            }
        }
    }

    private void removeMap(int[][] map, ArrayList<int[]> list) {
        for (int[] xy : list) {
            int x = xy[0];
            int y = xy[1];
            map[x][y] = 0;
            while (map[x][y + 1] != 0) {
                map[x][y] = map[x][y + 1];
                y++;
            }
        }

    }


    private void dfs(int[][] map, int x, int y, int val, ArrayList<int[]> list) {

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (nx >= 1 && ny >= 1 && nx <= 6 && ny <= 6 && map[nx][ny] == val) {
                count++;
                list.add(new int[]{nx, ny});
                dfs(map, nx, ny, val, list);
            }
        }

    }

    private void checkMap(int[][] map, int index, int color) {
        for (int i = 6; i >= 1; i--) {
            if (map[i][index] == 0) {
                //삽입
                map[i][index] = color;
            } else {
                continue;
            }
        }
    }


    public static void main(String[] args) {
        TEST4 t = new TEST4();
        t.solution(new int[][]{{1, 1}, {2, 1}, {1, 2}, {3, 3}, {6, 4}, {3, 1}, {3, 3}, {3, 3}, {3, 4}, {2, 1}});
    }
}

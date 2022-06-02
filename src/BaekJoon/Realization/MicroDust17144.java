package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class MicroDust17144 {
    static int R, C, T;
    static int[][] map;
    static ArrayList<int[]> list = new ArrayList<>();
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {-1, 1, 0, 0};
    static Queue<Dust> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        T = Integer.parseInt(st.nextToken());
        map = new int[R][C];

        for (int i = 0; i < R; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < C; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == -1) {
                    list.add(new int[]{i, j});
                }
                map[i][j] = num;
            }
        }
        int t = 0;
        while (t < T) {
            //0.미세먼지 큐 삽입
            checkQueue();

            //1.확산
            spread();

            //2.공기청정기
            airWash();

            t++;
        }
        int result = sum();
        System.out.println(result);
    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == -1) {
                    continue;
                }
                sum += map[i][j];
            }
        }
        return sum;
    }

    private static void airWash() {
        //위 반시계방향 회전
        int topX = list.get(0)[0];
        int topY = list.get(0)[1];

        int temp;
        temp = map[0][0];

        //오른쪽에서 왼쪽
        for (int i = 1; i < C; i++) {
            map[0][i - 1] = map[0][i];
        }
        //아래에서 위
        for (int i = 1; i <= topX; i++) {
            map[i - 1][C - 1] = map[i][C - 1];
        }
        //왼쪽에서 오른쪽
        for (int i = C - 2; i >= 0; i--) {
            if (i == topY) {
                map[topX][i + 1] = 0;
                continue;
            }
            map[topX][i + 1] = map[topX][i];
        }
        //위에서 아래
        for (int i = topX - 1; i >= 0; i--) {
            map[i + 1][0] = map[i][0];
        }
        map[1][0] = temp;
        map[topX][topY] = -1;

        //아래 시계방향 회전
        int downX = list.get(1)[0];
        int downY = list.get(1)[1];

        temp = map[R - 1][0];

        //오른쪽에서 왼쪽
        for (int i = 1; i < C; i++) {
            map[R - 1][i - 1] = map[R - 1][i];
        }
        //위에서 아래
        for (int i = R - 2; i >= downX; i--) {
            map[i + 1][C - 1] = map[i][C - 1];
        }
        //왼쪽에서 오른쪽
        for (int i = C - 2; i >= 0; i--) {
            if (i == downY) {
                map[downX][i + 1] = 0;
                continue;
            }
            map[downX][i + 1] = map[downX][i];
        }
        //아래에서 위
        for (int i = downX + 1; i < R; i++) {
            map[i - 1][0] = map[i][0];
        }
        map[R - 2][0] = temp;
        map[downX][downY] = -1;

    }

    private static void checkQueue() {
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                if (map[i][j] == 0 || map[i][j] == -1) {
                    continue;
                }
                queue.add(new Dust(i, j, map[i][j]));
            }
        }
    }

    private static void spread() {
        int[][] temp = new int[R][C];

        while (!queue.isEmpty()) {
            Dust dust = queue.poll();
            int x = dust.x;
            int y = dust.y;
            int oriAmount = dust.amount;
            int spreadAmount = oriAmount / 5;
            int cnt = 0;
            for (int i = 0; i < 4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];
                if (nx >= 0 && ny >= 0 && nx < R && ny < C && map[nx][ny] != -1) {
                    temp[nx][ny] += spreadAmount;
                    cnt++;
                }
            }
            oriAmount -= spreadAmount * cnt;
            temp[x][y] += oriAmount;
        }
        map = temp.clone();
        map[list.get(0)[0]][list.get(0)[1]] = -1;
        map[list.get(1)[0]][list.get(1)[1]] = -1;
    }

    private static void show() {
        System.out.println("==================");
        for (int i = 0; i < map.length; i++) {
            System.out.println(Arrays.toString(map[i]));
        }
    }
}

class Dust {
    int x;
    int y;
    int amount;

    public Dust(int x, int y, int amount) {
        this.x = x;
        this.y = y;
        this.amount = amount;
    }
}
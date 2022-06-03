package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Slope14890 {
    static int N;
    static int L;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        int[][] map = new int[N][N];
        int[][] map2 = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                int val = Integer.parseInt(st.nextToken());
                map[i][j] = val;
                map2[j][i] = val;
            }
        }

        // 가로 검사
        for (int x = 0; x < N; x++) {
            check(x, map);
            check(x, map2);
        }
        System.out.println(result);

    }

    private static void check(int x, int[][] map) {
        boolean[] visited = new boolean[N];
        for (int i = 0; i < N - 1; i++) {
            if (map[x][i] != map[x][i + 1]) {
                int diff = map[x][i] - map[x][i + 1];
                if (diff != -1 && diff != 1) {
                    return;
                }

                if (diff == 1) {
                    //내리막
                    for (int j = 1; j <= L; j++) {
                        if (i + j >= N || visited[i + j]) {
                            return;
                        }
                        if (map[x][i] - 1 == map[x][i + j]) {
                            visited[i + j] = true;
                        } else {
                            return;
                        }
                    }
                } else if (diff == -1) {
                    //오르막
                    for (int j = 0; j < L; j++) {
                        if (i - j < 0 || visited[i - j]) {
                            return;
                        }
                        if (map[x][i] == map[x][i - j]) {
                            visited[i - j] = true;
                        } else {
                            return;
                        }
                    }
                }
            }
        }
        result++;

    }
}

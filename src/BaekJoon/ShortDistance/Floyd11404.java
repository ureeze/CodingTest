package BaekJoon.ShortDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Floyd11404 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        long[][] map = new long[n + 1][n + 1];
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (i == j) {
                    map[i][j] = 0;
                } else {
                    map[i][j] = Integer.MAX_VALUE;
                }
            }
        }
        StringTokenizer st;
for (int i = 0; i < m; i++) {
    st = new StringTokenizer(br.readLine());
    int a = Integer.parseInt(st.nextToken());
    int b = Integer.parseInt(st.nextToken());
    int c = Integer.parseInt(st.nextToken());

    map[a][b] = Math.min(map[a][b], c);
}
        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 1; i < map.length; i++) {
            for (int j = 1; j < map[i].length; j++) {
                if (map[i][j] == Integer.MAX_VALUE) {
                    map[i][j] = 0;
                }
                sb.append(map[i][j]).append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}
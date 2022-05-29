package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class ChickenDelivery15686 {
    static int N;
    static int M;
    static int[][] map;
    static ArrayList<int[]> chicken;
    static ArrayList<int[]> house;
    static boolean[] visited;
    static int minTotalChicken = 9999;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        chicken = new ArrayList<>();
        house = new ArrayList<>();
        map = new int[N][N];
        for (int i = 0; i < map.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < map[i].length; j++) {
                int num = Integer.parseInt(st.nextToken());
                if (num == 1) {
                    house.add(new int[]{i, j});
                } else if (num == 2) {
                    chicken.add(new int[]{i, j});
                }
                map[i][j] = num;
            }
        }
        visited = new boolean[chicken.size()];
        dfs(0, 0);
        System.out.println(minTotalChicken);
    }

    private static void dfs(int startIdx, int depth) {
        if (depth == M) {
            bfs();

            return;
        }

        for (int i = startIdx; i < chicken.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i + 1, depth + 1);
                visited[i] = false;
            }
        }

    }

    private static void bfs() {
        int totalChicken = 0;
        for (int[] arr : house) {
            int x = arr[0];
            int y = arr[1];
            int min = 9999;
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) {
                    int dist = Math.abs(x - chicken.get(i)[0]) + Math.abs(y - chicken.get(i)[1]);
                    min = Math.min(dist, min);
                }
            }
            totalChicken += min;
        }
        minTotalChicken = Math.min(totalChicken, minTotalChicken);
    }
}

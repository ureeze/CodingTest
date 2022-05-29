package BaekJoon.Backtracking;

import java.io.*;
import java.util.*;

public class NM15649 {
    static int N;
    static int M;
    static boolean[] visited;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        arr = new int[M];
        StringBuilder sb = new StringBuilder();
        visited = new boolean[N + 1];

        dfs(0);


    }

    private static void dfs(int depth) {
        if (depth == M) {
            System.out.println(Arrays.toString(arr));
            return;
        }
        for (int i = 1; i < N + 1; i++) {
            if (!visited[i]) {
                arr[depth] = i;
                visited[i] = true;
                dfs(depth + 1);
                visited[i] = false;
            }
        }
    }
}

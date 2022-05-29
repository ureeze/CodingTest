package BaekJoon.BFSDFS;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BFSDFS {
    private static boolean[] visited;
    private static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
    private static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        for (int i = 0; i < N + 1; i++) {
            graph.get(i).sort(null);
        }

        visited = new boolean[N + 1];
        visited[V] = true;
        sb = new StringBuilder();
        sb.append(V).append(" ");
        dfs(V);
        System.out.println(sb.toString());
        System.out.println("================");

        visited = new boolean[N + 1];
        visited[V] = true;
        sb = new StringBuilder();
        sb.append(V).append(" ");
        bfs(V);
        System.out.println(sb.toString());
    }

    private static void bfs(int v) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v);

        while (!queue.isEmpty()) {
            int x = queue.poll();

            for (int y : graph.get(x)) {
                if (!visited[y]) {
                    visited[y] = true;
                    sb.append(y).append(" ");
                    queue.add(y);
                }
            }
        }
    }

    private static void dfs(int v) {
        for (int x : graph.get(v)) {
            if (!visited[x]) {
                visited[x] = true;
                sb.append(x).append(" ");
                dfs(x);
            }
        }
    }
}
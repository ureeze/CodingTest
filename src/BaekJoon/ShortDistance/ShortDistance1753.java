package BaekJoon.ShortDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ShortDistance1753 {
    static boolean[] visited;
    static int[] distance;
    static ArrayList<ArrayList<int[]>> graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        graph = new ArrayList<>();
        st = new StringTokenizer(br.readLine());

        int V = Integer.parseInt(st.nextToken());
        int E = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new int[]{v, w});
        }
        visited = new boolean[V + 1];
        distance = new int[V + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k] = 0;

        dijkstra(k);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < V; i++) {
            if (distance[i + 1] == Integer.MAX_VALUE) {
                sb.append("INF").append("\n");
            } else {
                sb.append(distance[i + 1]).append("\n");
            }
        }
        System.out.println(sb);
    }

    private static void dijkstra(int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((o1, o2) -> o1[1] - o2[1]);  // [0]노드번호, [1]최단거리
        pq.offer(new int[]{k, distance[k]});

        while (!pq.isEmpty()) {
            int[] node = pq.poll();
            int index = node[0];
            if (visited[index]) {
                continue;
            }
            visited[index] = true;

            for (int[] next : graph.get(index)) {
                int nextIdx = next[0];
                int nextWeight = next[1];

                if (distance[nextIdx] > distance[index] + nextWeight) {
                    distance[nextIdx] = distance[index] + nextWeight;
                    pq.offer(new int[]{nextIdx, distance[nextIdx]});
                }
            }
        }
    }
}
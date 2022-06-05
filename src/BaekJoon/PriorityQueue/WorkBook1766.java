package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class WorkBook1766 {
    static int N, M;
    static ArrayList<ArrayList<Integer>> graph = new ArrayList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int[] indegree = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            graph.add(new ArrayList<>());
        }


        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int v1 = Integer.parseInt(st.nextToken());
            int v2 = Integer.parseInt(st.nextToken());
            graph.get(v1).add(v2);
            indegree[v2]++;
        }
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 1; i < N + 1; i++) {
            if (indegree[i] == 0) {
                pq.offer(i);
            }
        }
        while (!pq.isEmpty()) {
            int num = pq.poll();
            sb.append(num).append(" ");

            for (int link : graph.get(num)) {
                indegree[link]--;
                if (indegree[link] == 0) {
                    pq.offer(link);
                }
            }
        }
        System.out.println(sb.toString());
    }
}
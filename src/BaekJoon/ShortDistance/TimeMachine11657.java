package BaekJoon.ShortDistance;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class TimeMachine11657 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        boolean mCycle = false;
        long[] dist = new long[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[1] = 0;

        ArrayList<Edge11657> edgeList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int startIdx = Integer.parseInt(st.nextToken());
            int endIdx = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            edgeList.add(new Edge11657(startIdx, endIdx, weight));
        }
        for (int i = 1; i < n; i++) {
            for (Edge11657 edge : edgeList) {
                int startIdx = edge.startIdx;
                int endIdx = edge.endIdx;
                int weight = edge.weight;

                if (dist[startIdx] != Integer.MAX_VALUE && dist[endIdx] > dist[startIdx] + weight) {
                    dist[endIdx] = dist[startIdx] + weight;
                }
            }
        }

        for (Edge11657 edge : edgeList) {
            int startIdx = edge.startIdx;
            int endIdx = edge.endIdx;
            int weight = edge.weight;

            if (dist[startIdx] != Integer.MAX_VALUE && dist[endIdx] > dist[startIdx] + weight) {
                mCycle = true;
            }
        }

        StringBuilder sb = new StringBuilder();
        if (mCycle) {
            sb.append(-1);
        } else {
            for (int i = 2; i < dist.length; i++) {
                if (dist[i] == Integer.MAX_VALUE) {
                    sb.append(-1).append("\n");
                } else {
                    sb.append(dist[i]).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

class Edge11657 {
    int startIdx;
    int endIdx;
    int weight;

    public Edge11657(int startIdx, int endIdx, int weight) {
        this.startIdx = startIdx;
        this.endIdx = endIdx;
        this.weight = weight;
    }
}

package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MidVal2696 {
    static int T, M;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        T = Integer.parseInt(br.readLine());
        StringBuilder result = new StringBuilder();

        StringTokenizer st = null;
        for (int k = 0; k < T; k++) {
            int count = 0;
            StringBuilder sb = new StringBuilder();
            PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o2 - o1);
            PriorityQueue<Integer> minHeap = new PriorityQueue<>();
            M = Integer.parseInt(br.readLine());
            for (int i = 0; i < M; i++) {
                if (i % 10 == 0) {
                    st = new StringTokenizer(br.readLine());
                }
                int n = Integer.parseInt(st.nextToken());

                if (maxHeap.size() == minHeap.size()) {
                    maxHeap.offer(n);
                } else {
                    minHeap.offer(n);
                }

                if (!minHeap.isEmpty()) {
                    if (maxHeap.peek() > minHeap.peek()) {
                        int n1 = minHeap.poll();
                        int n2 = maxHeap.poll();

                        maxHeap.offer(n1);
                        minHeap.offer(n2);
                    }
                }
                if (i % 2 == 0) {
                    count++;
                    if (i > 0 && count % 10 == 1) {
                        sb.append("\n").append(maxHeap.peek()).append(" ");
                    } else
                        sb.append(maxHeap.peek()).append(" ");
                }
            }
            result.append(count).append("\n").append(sb.toString()).append("\n");
        }
        System.out.println(result.toString());
    }
}
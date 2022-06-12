package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ClassRoom1374 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Node1374> list = new ArrayList<>();
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int index = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node1374(index, start, end));
        }
        list.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        for (Node1374 node : list) {
            if (!pq.isEmpty()) {
                if (node.start >= pq.peek()) {
                    pq.poll();
                }
            }
            pq.offer(node.end);
        }

        System.out.println(pq.size());
    }
}

class Node1374 {
    int idx;
    int start;
    int end;

    public Node1374(int idx, int start, int end) {
        this.idx = idx;
        this.start = start;
        this.end = end;
    }

    @Override
    public String toString() {
        return "{idx=" + idx +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
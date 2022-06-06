package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class ClassRoom11000 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        ArrayList<Node11000> list = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            list.add(new Node11000(start, end));
        }
        list.sort((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        for (int i = 0; i < list.size(); i++) {
            if (pq.isEmpty()) {
                pq.offer(list.get(i).end);
            } else {
                int endTime = pq.peek();
                if (list.get(i).start >= endTime) {
                    pq.poll();
                    pq.offer(list.get(i).end);
                }else{
                    pq.offer(list.get(i).end);
                }
            }
        }
        System.out.println(pq.size());

    }
}

class Node11000 {
    int start;
    int end;

    public Node11000(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
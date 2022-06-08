package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CupRamen1781 {
    static int N;
    static PriorityQueue<Node1781> pq;
    static ArrayList<Node1781> list;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        list = new ArrayList<>();
        pq = new PriorityQueue<>((o1, o2) -> {
            return o1.ramenCnt - o2.ramenCnt;
        });
        StringTokenizer st;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node1781(i + 1, Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }

        list.sort((o1, o2) -> {
            if (o1.deadLine == o2.deadLine) {
                return o2.ramenCnt - o1.ramenCnt;
            }
            return o1.deadLine - o2.deadLine;
        });

        int deadLine = 1, total = 0;
        for (int i = 0; i < list.size(); i++) {
            Node1781 node = list.get(i);
            if (pq.size() < node.deadLine) {
                pq.offer(node);
            } else if (pq.size() >= deadLine) {
                if (node.ramenCnt > pq.peek().ramenCnt) {
                    pq.poll();
                    pq.offer(node);
                }
            }
        }

        while (!pq.isEmpty()) {
            total += pq.poll().ramenCnt;
        }
        System.out.println(total);


    }
}

class Node1781 {
    int index;
    int deadLine;
    int ramenCnt;

    public Node1781(int index, int deadLine, int ramenCnt) {
        this.index = index;
        this.deadLine = deadLine;
        this.ramenCnt = ramenCnt;
    }

    @Override
    public String toString() {
        return " {index=" + index +
                ", deadLine=" + deadLine +
                ", ramenCnt=" + ramenCnt +
                '}';
    }
}

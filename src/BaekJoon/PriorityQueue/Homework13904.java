package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Homework13904 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node13904> list = new ArrayList<>();
        PriorityQueue<Node13904> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.score - o2.score;
        });
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            list.add(new Node13904(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        list.sort((o1, o2) -> {
            if (o1.day == o2.day) {
                return o2.score - o1.score;
            }
            return o1.day - o2.day;
        });

        for (Node13904 node : list) {
            if (pq.size() < node.day) {
                pq.offer(node);
            } else if (pq.size() == node.day) {
                Node13904 n1 = pq.peek();
                if (n1.score < node.score) {
                    pq.poll();
                    pq.offer(node);
                }
            }
        }
        int total = 0;
        while (!pq.isEmpty()) {
            Node13904 n = pq.poll();
            total += n.score;
        }
        System.out.println(total);
    }
}

class Node13904 {
    int day;
    int score;

    public Node13904(int day, int score) {
        this.day = day;
        this.score = score;
    }
}
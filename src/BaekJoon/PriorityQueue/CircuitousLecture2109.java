package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CircuitousLecture2109 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        ArrayList<Node2109> list = new ArrayList<>();
        while (N-- > 0) {
            st = new StringTokenizer(br.readLine());
            int pay = Integer.parseInt(st.nextToken());
            int day = Integer.parseInt(st.nextToken());
            list.add(new Node2109(day, pay));
        }
        list.sort((o1, o2) -> {
            if (o1.day == o2.day) {
                return o2.pay - o1.pay;
            }
            return o1.day - o2.day;
        });
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (Node2109 node : list) {
            if (pq.size() < node.day) {
                pq.offer(node.pay);
            } else if (pq.size() == node.day) {
                if (pq.peek() < node.pay) {
                    pq.poll();
                    pq.offer(node.pay);
                }
            }
        }
        int result = 0;
        while (!pq.isEmpty()) {
            result += pq.poll();
        }
        System.out.println(result);
    }
}

class Node2109 {
    int day;
    int pay;

    public Node2109(int day, int pay) {
        this.day = day;
        this.pay = pay;
    }

    @Override
    public String toString() {
        return " {day=" + day +
                ", pay=" + pay +
                '}';
    }
}
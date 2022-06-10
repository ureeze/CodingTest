package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class TrainLine13334 {
    static ArrayList<Node13334> list = new ArrayList<>();
    static int n, L, max;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        StringTokenizer st;

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            int home = Integer.parseInt(st.nextToken());
            int office = Integer.parseInt(st.nextToken());
            if (home < office) {
                list.add(new Node13334(home, office));
            } else {
                list.add(new Node13334(office, home));
            }
        }
        L = Integer.parseInt(br.readLine());

        list.sort((o1, o2) -> {
            if (o1.office == o2.office) {
                return o1.home - o2.home;
            }
            return o1.office - o2.office;
        });

        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1.compareTo(o2));

        max = 0;
        for (int i = 0; i < n; i++) {
            Node13334 node = list.get(i);
            int start = node.home;
            int end = node.office;
            if (end - L > start) {
                continue;
            }
            pq.offer(start);
            while (!pq.isEmpty() && pq.peek() < end - L) {
                pq.poll();
            }
            max = Math.max(pq.size(), max);
        }
        System.out.println(max);
    }
}

class Node13334 {
    int home;
    int office;

    public Node13334(int home, int office) {
        this.home = home;
        this.office = office;
    }

    @Override
    public String toString() {
        return "{home=" + home +
                ", office=" + office +
                '}';
    }
}

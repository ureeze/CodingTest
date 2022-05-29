package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class CardSort1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>((o1, o2) -> o1 - o2);
        for (int i = 0; i < n; i++) {
            pq.offer(Integer.parseInt(br.readLine()));
        }
        int answer = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            answer += num1 + num2;
            pq.offer(num1 + num2);
        }
        System.out.println(answer);
    }
}

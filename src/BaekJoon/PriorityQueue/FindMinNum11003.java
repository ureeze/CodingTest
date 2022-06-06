package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class FindMinNum11003 {
    static int N, L;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        L = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        Deque<Node11003> deque = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < N; i++) {
            int next = Integer.parseInt(st.nextToken());

            while (!deque.isEmpty() && deque.peekLast().value > next) {
                deque.removeLast();
            }
            deque.offer(new Node11003(i, next));
            if (deque.peekFirst().index < i - L + 1) {
                deque.removeFirst();
            }
            sb.append(deque.peekFirst().value).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Node11003 {
    int index;
    int value;

    public Node11003(int index, int value) {
        this.index = index;
        this.value = value;
    }
}
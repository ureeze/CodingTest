package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class MinMeetingRoom19598 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        PriorityQueue<Class19598> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.start == o2.start) {
                return o1.end - o2.end;
            }
            return o1.start - o2.start;
        });

        PriorityQueue<Integer> meetRoom = new PriorityQueue<>((o1, o2) -> o1 - o2);
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            pq.offer(new Class19598(start, end));
        }

        while (!pq.isEmpty()) {
            Class19598 c = pq.poll();

            if (!meetRoom.isEmpty()) {
                if (c.start >= meetRoom.peek()) {
                    meetRoom.poll();
                }
            }
            meetRoom.offer(c.end);
        }
        System.out.println(meetRoom.size());
    }
}

class Class19598 {
    int start;
    int end;

    public Class19598(int start, int end) {
        this.start = start;
        this.end = end;
    }
}
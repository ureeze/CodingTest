package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class FillFuel1826 {
    static int N, L, P;
    static PriorityQueue<GasStation> pq = new PriorityQueue<>((o1, o2) -> o1.loc - o2.loc);

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            pq.add(new GasStation(a, b));
        }
        st = new StringTokenizer(br.readLine());
        L = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());
        PriorityQueue<Integer> fuels = new PriorityQueue<>((o1, o2) -> o2 - o1);

        int count = 0;
        while (P < L) {
            while (!pq.isEmpty() && pq.peek().loc <= P) {
                fuels.offer(pq.poll().fuel);
            }
            if (fuels.isEmpty()) {
                System.out.println(-1);
                return;
            }
            count++;
            P += fuels.poll();
        }
        System.out.println(count);
    }
}

class GasStation {
    int loc;
    int fuel;

    public GasStation(int loc, int fuel) {
        this.loc = loc;
        this.fuel = fuel;
    }

    @Override
    public String toString() {
        return "{loc=" + loc +
                ", fuel=" + fuel +
                '}';
    }
}
package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Gem1202 {
    static int N, K;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        ArrayList<Gem> gemList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gemList.add(new Gem(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        gemList.sort((o1, o2) -> o1.weight - o2.weight);

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }
        Arrays.sort(bags);

        PriorityQueue<Gem> gems = new PriorityQueue<>((o1, o2) -> {
            if (o1.cost == o2.cost) {
                return o1.weight - o2.weight;
            }
            return o2.cost - o1.cost;
        });

        long total = 0;
        int index = 0;
        for (int i = 0; i < K; i++) {
            int bag = bags[i];
            while (index < N && gemList.get(index).weight <= bag) {
                gems.offer(gemList.get(index));
                index++;
            }
            if (!gems.isEmpty()) {
                Gem maxGem = gems.poll();
                total += maxGem.cost;
            }
        }
        System.out.println(total);
    }
}

class Gem {
    int weight;
    int cost;

    public Gem(int weight, int cost) {
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Gem{" +
                "weight=" + weight +
                ", cost=" + cost +
                '}';
    }
}
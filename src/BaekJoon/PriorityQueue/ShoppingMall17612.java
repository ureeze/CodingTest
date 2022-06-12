package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ShoppingMall17612 {
    static int N, k;
    static Queue<User17612> userWait = new LinkedList<>();
    static PriorityQueue<Counter17612> using = new PriorityQueue<>((o1, o2) -> {
        if (o1.endTime == o2.endTime) {
            return o1.counterId - o2.counterId;
        }
        return o1.endTime - o2.endTime;
    });
    static PriorityQueue<Counter17612> exit = new PriorityQueue<>((o1, o2) -> {
        if (o1.endTime == o2.endTime) {
            return o2.counterId - o1.counterId;
        }
        return o1.endTime - o2.endTime;
    });
    static PriorityQueue<int[]> exit1 = new PriorityQueue<>((o1, o2) -> {
        if (o1[2] == o2[2]) {
            return o2[0] - o1[0];
        }
        return o1[2] - o2[2];
    });
    static int nowTime = 0;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int id = Integer.parseInt(st.nextToken());
            int count = Integer.parseInt(st.nextToken());
            userWait.offer(new User17612(id, count));
        }

        for (int i = 0; i < k; i++) {
            using.offer(new Counter17612(i, 0, 0));
        }

        while (!userWait.isEmpty()) {
            User17612 user = userWait.poll();

            Counter17612 counter = using.poll();
            if (counter.userId != 0) {
//                exit.offer(new Counter17612(counter.counterId, counter.userId, counter.endTime));
                exit1.offer(new int[]{counter.counterId, counter.userId, counter.endTime});
            }
            nowTime = counter.endTime;

            counter.userId = user.id;
            counter.endTime = nowTime + user.time;

            using.offer(counter);
        }
        while (!using.isEmpty()) {
            Counter17612 c = using.poll();
            exit1.offer(new int[]{c.counterId, c.userId, c.endTime});
        }
        long num = 1;
        long result = 0;
        while (!exit1.isEmpty()) {
            int[] arr = exit1.poll();
            result += num++ * (long) arr[1];
        }
        System.out.println(result);
    }
}

class User17612 {
    int id;
    int time;

    public User17612(int id, int time) {
        this.id = id;
        this.time = time;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                ", time=" + time +
                '}';
    }
}

class Counter17612 {
    int counterId;
    int userId;
    int endTime;

    public Counter17612(int counterId, int userId, int endTime) {
        this.counterId = counterId;
        this.userId = userId;
        this.endTime = endTime;
    }

    @Override
    public String toString() {
        return "{" +
                "counterId=" + counterId +
                ", userId=" + userId +
                ", endTime=" + endTime +
                '}';
    }
}

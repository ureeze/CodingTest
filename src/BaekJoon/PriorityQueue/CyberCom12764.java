package BaekJoon.PriorityQueue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class CyberCom12764 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<Person12764> pq = new PriorityQueue<>((o1, o2) -> {
            if (o1.startTime == o2.startTime) {
                return o1.endTime - o2.endTime;
            }
            return o1.startTime - o2.startTime;
        });

        PriorityQueue<Computer12764> comps = new PriorityQueue<>((o1, o2) -> {
            if (o1.endTime == o2.endTime) {
                return o1.index - o2.index;
            }
            return o1.endTime - o2.endTime;
        });
        int N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            pq.offer(new Person12764(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())));
        }
        int i = 1;
        while (!pq.isEmpty()) {
            Person12764 p = pq.poll();

            if (comps.isEmpty()) {
                comps.offer(new Computer12764(i++, p.endTime, 1));
            } else {
                Computer12764 c = comps.peek();
                if (p.startTime < c.endTime) {
                    comps.offer(new Computer12764(i++, p.endTime, 1));
                } else {
                    comps.poll();
                    comps.offer(new Computer12764(c.index, p.endTime, c.count + 1));
                }
            }
        }
        System.out.println(comps);
        StringBuilder sb = new StringBuilder();
        ArrayList<Computer12764> list;
        sb.append(comps.size()).append("\n");
        list = new ArrayList<>(comps);
        list.sort((o1, o2) -> o1.index - o2.index);
        for (Computer12764 c : list) {
            sb.append(c.count).append(" ");
        }
        System.out.println(sb.toString());
    }
}

class Person12764 {
    int startTime;
    int endTime;

    public Person12764(int startTime, int endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }
}

class Computer12764 {
    int index;
    int endTime;
    int count;

    public Computer12764(int index, int endTime, int count) {
        this.index = index;
        this.endTime = endTime;
        this.count = count;
    }

    @Override
    public String toString() {
        return "{" +
                "index=" + index +
                ", endTime=" + endTime +
                ", count=" + count +
                '}';
    }
}
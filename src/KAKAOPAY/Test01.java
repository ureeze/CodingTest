package KAKAOPAY;

import java.util.*;

public class Test01 {
    public int[] solution(int region, int num, int[][] info) {
        int[] answer = new int[info.length];
        PriorityQueue<Person> pq1 = new PriorityQueue<>((o1, o2) -> {
            if (o2.score == o1.score) {
                return o1.index - o2.index;
            }
            return o2.score - o1.score;
        });
        PriorityQueue<Person> pq2 = new PriorityQueue<>((o1, o2) -> {
            if (o2.score == o1.score) {
                return o1.index - o2.index;
            }
            return o2.score - o1.score;
        });
        scoreCal(info, pq1, pq2, region);
        int i = 1;
        while (!pq1.isEmpty()) {
            Person p = pq1.poll();
            if (num != 0) {
                answer[p.index] = i;
                num--;
            } else {
                answer[p.index] = -1;
            }
            i++;
        }
        while (!pq2.isEmpty()) {
            Person p = pq2.poll();
            if (num != 0) {
                answer[p.index] = i;
                num--;
            } else {
                answer[p.index] = -1;
            }
            i++;
        }

        return answer;
    }

    private void scoreCal(int[][] info, PriorityQueue<Person> pq1, PriorityQueue<Person> pq2, int region) {
        for (int i = 0; i < info.length; i++) {
            int score = (info[i][1] + 1) * 2 + (info[i][2] + 2) + (info[i][3] + 1) * 5;
            Person p = new Person(i, score);
            if (info[i][0] == region) {
                pq1.offer(p);
            } else {
                pq2.offer(p);
            }
        }
    }

    public static void main(String[] args) {
        Test01 test01 = new Test01();
        System.out.println(Arrays.toString(test01.solution(2, 4, new int[][]{{1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}})));
        System.out.println(Arrays.toString(test01.solution(3, 2, new int[][]{{3, 8, 6, 2}, {1, 12, 5, 2}, {3, 2, 9, 5}, {3, 6, 10, 1}, {1, 10, 5, 3}})));
        System.out.println(Arrays.toString(test01.solution(1, 7, new int[][]{{1, 0, 2, 1}, {2, 6, 5, 2}, {3, 10, 2, 4}, {1, 1, 5, 6}, {2, 7, 10, 2}, {3, 8, 6, 3}})));
    }

}

class Person {
    int index;
    int score;

    public Person(int index, int score) {
        this.index = index;
        this.score = score;
    }
}
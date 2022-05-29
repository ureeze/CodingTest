package Programmers.SOCAR2022;

import java.util.*;

class TEST1 {
    static ArrayList<ArrayList<Node>> list;
    static Set<Integer> resultSet;

    public int[] solution(int n, int k, int[][] roads) {
        list = new ArrayList<>();
        resultSet = new HashSet<>();

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            int idx1 = roads[i][0], idx2 = roads[i][1], cost = roads[i][2];
            list.get(idx1).add(new Node(idx2, cost));
            list.get(idx2).add(new Node(idx1, cost));
        }

        bfs(0, 0, k);
        List<Integer> result = new ArrayList<>(resultSet);
        Collections.sort(result);
        if (result.size() == 0) {
            return new int[]{-1};
        } else {
            int[] arr = new int[result.size()];
            for (int i=0; i<result.size();i++) {
                arr[i]= result.get(i);
            }
            return arr;
        }

    }

    private void bfs(int a, int start, int k) {
        Queue<Node> queue = new LinkedList<>();
        queue.offer(new Node(a, start));

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int total = currentNode.cost;
            for (Node next : list.get(currentNode.index)) {
                if (total + next.cost == k) {
                    resultSet.add(next.index);
                } else if (total + next.cost < k) {
                    queue.offer(new Node(next.index, total + next.cost));
                }
            }
        }

    }

    public class Node {
        private int index;
        private int cost;

        public Node(int index, int cost) {
            this.index = index;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        TEST1 test1 = new TEST1();
        System.out.println(Arrays.toString(test1.solution(6, 17, new int[][]{{5, 4, 6}, {5, 2, 5}, {0, 4, 2}, {2, 3, 3}, {1, 2, 7}, {0, 1, 3}})));
        System.out.println(Arrays.toString(test1.solution(4, 10, new int[][]{{0, 1, 2}, {0, 2, 3}})));
        System.out.println(Arrays.toString(test1.solution(4, 11, new int[][]{{0, 1, 2}, {1, 2, 7}, {2, 3, 10}, {3, 0, 9}})));
    }

}

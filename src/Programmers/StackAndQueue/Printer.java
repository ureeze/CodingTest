package Programmers.StackAndQueue;

import java.util.*;
import java.util.stream.Collectors;

public class Printer {
    public int solution(int[] priorities, int location) {
        Queue<Node1> queue = new LinkedList<>();

        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Node1(i, priorities[i]));
        }
        List<Integer> list = Arrays.stream(priorities).boxed().collect(Collectors.toList());
        list.sort((o1, o2) -> o2.compareTo(o1));
        Queue<Integer> priorityQueue = new LinkedList<>(list);
        System.out.println(priorityQueue.toString());
        int count = 0;
        while (!queue.isEmpty()) {
            if (queue.peek().value == priorityQueue.peek()) {
                Node1 node1 = queue.poll();
                priorityQueue.poll();
                count++;

                if (node1.index == location) {
                    return count;
                }
            } else {
                queue.add(queue.poll());
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        Printer p = new Printer();
        System.out.println(p.solution(new int[]{1, 1, 9, 1, 1, 1}, 0));
    }
}

class Node1 {
    int index;
    int value;

    public Node1(int index, int value) {
        this.index = index;
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "index=" + index +
                ", value=" + value +
                '}';
    }
}
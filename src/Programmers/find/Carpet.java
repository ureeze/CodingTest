package Programmers.find;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Carpet {
    public int[] solution(int brown, int yellow) {
        double num = Math.sqrt(yellow);
        int[] arr = new int[2];
        List<Node2> list = new ArrayList<>();
        for (int i = 1; i <= num; i++) {
            if (yellow % i == 0) {
                list.add(new Node2(i, yellow / i));
            }
        }
        System.out.println(list.toString());
        for (Node2 node2 : list) {
            int x = node2.a + 2;
            int y = node2.b + 2;
            if (x * y == brown + yellow) {
                return x > y ? new int[]{x, y} : new int[]{y, x};
            }
        }
        return null;
    }

    public static void main(String[] args) {

        Carpet c = new Carpet();
        System.out.println(Arrays.toString(c.solution(10, 2)));
        System.out.println(Arrays.toString(c.solution(8, 1)));
        System.out.println(Arrays.toString(c.solution(24, 24)));
    }

}

class Node2 {
    int a;
    int b;

    public Node2(int a, int b) {
        this.a = a;
        this.b = b;
    }

    @Override
    public String toString() {
        return "Node2{" +
                "a=" + a +
                ", b=" + b +
                '}';
    }
}
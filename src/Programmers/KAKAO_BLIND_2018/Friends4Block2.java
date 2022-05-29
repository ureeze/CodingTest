package Programmers.KAKAO_BLIND_2018;

import java.util.HashSet;
import java.util.Objects;

public class Friends4Block2 {
    public int solution(int m, int n, String[] board) {
        HashSet<Node1> set = new HashSet<>();
        String[][] map = new String[m][n];
        for (int i = 0; i < m; i++) {
            map[i] = board[i].split("");
        }
        int count = 0;
        while (true) {
            for (int i = 0; i < map.length - 1; i++) {
                for (int j = 0; j < map[i].length - 1; j++) {
                    String s = map[i][j];
                    if (s != "1" && s != "0" && s.equals(map[i][j + 1]) && s.equals(map[i + 1][j]) && s.equals(map[i + 1][j + 1])) {
                        set.add(new Node1(i, j));
                        set.add(new Node1(i, j + 1));
                        set.add(new Node1(i + 1, j));
                        set.add(new Node1(i + 1, j + 1));
//                        map[i][j] = "1";
//                        map[i][j + 1] = "1";
//                        map[i + 1][j] = "1";
//                        map[i + 1][j + 1] = "1";

                    }
                }
            }
            if (set.isEmpty()) {
                break;
            } else {
                for (Node1 node : set) {
                    int x = node.x;
                    int y = node.y;
                    map[x][y] = "1";
                    count++;
                }
                set.clear();
            }

            for (int i = 0; i < m; i++) {
                for (int j = 0; j < n; j++) {
                    if (map[i][j].equals("1")) {
                        for (int k = i - 1; k >= 0; k--) {
                            map[k + 1][j] = map[k][j];
                            map[k][j] = "0";

                        }
                    }
                }
            }
        }

        return count;
    }


    public static void main(String[] args) {
        Friends4Block2 f = new Friends4Block2();
        System.out.println(f.solution(4, 5, new String[]{"CCBDE", "AAADE", "AAABF", "CCBBF"}));
        System.out.println(f.solution(6, 6, new String[]{"TTTANT", "RRFACC", "RRRFCC", "TRRRAA", "TTMMMF", "TMMTTJ"}));
    }
}

class Node1 {
    int x;
    int y;

    public Node1(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return "Node1{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Node1 node1 = (Node1) o;
        return x == node1.x && y == node1.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }
}
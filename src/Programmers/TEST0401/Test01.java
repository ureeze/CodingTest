package Programmers.TEST0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Test01 {
    public String[] solution(String path) {
        ArrayList<String> list = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        divide(path, queue);
        int time = 0;
        while (!queue.isEmpty()) {
            String curStr = queue.poll();
            int totalLen = curStr.length();
            if (!queue.isEmpty()) {
                //방향전환되므로 출력가능
                if (totalLen <= 5 && totalLen > 0) {
                    String dir = checkDir(curStr.charAt(0), queue.peek().charAt(0));
                    list.add("Time " + time + ": Go straight " + totalLen * 100 + "m and turn " + dir);
                    time += totalLen;
                } else if (totalLen > 5) {
                    String dir = checkDir(curStr.charAt(0), queue.peek().charAt(0));
                    time += totalLen - 5;
                    list.add("Time " + time + ": Go straight " + 500 + "m and turn " + dir);
                    time += 5;
                }
            }
        }

        String[] arr = list.toArray(new String[list.size()]);
        return arr;
    }

    private String checkDir(char prev, char next) {
        String dir = "";
        switch (prev) {
            case 'E':
                if (next == 'S') {
                    dir = "right";
                } else if (next == 'N') {
                    dir = "left";
                }
                break;
            case 'S':
                if (next == 'E') {
                    dir = "left";
                } else if (next == 'W') {
                    dir = "right";
                }
                break;
            case 'W':
                if (next == 'S') {
                    dir = "left";
                } else if (next == 'N') {
                    dir = "right";
                }
                break;
            case 'N':
                if (next == 'W') {
                    dir = "left";
                } else if (next == 'E') {
                    dir = "right";
                }
                break;
        }
        return dir;
    }

    private void divide(String path, Queue<String> queue) {
        StringBuilder sb = new StringBuilder();
        sb.append(path.charAt(0));
        char temp = path.charAt(0);
        for (int i = 1; i < path.length(); i++) {
            char c = path.charAt(i);
            if (temp == c) {
                sb.append(c);
            } else {
                queue.offer(sb.toString());
                sb = new StringBuilder();
                sb.append(c);
                temp = c;
            }
            if (i == path.length() - 1) {
                queue.add(sb.toString());
            }
        }
    }

    public static void main(String[] args) {
        Test01 t = new Test01();
        System.out.println(Arrays.toString(t.solution("EEESEEEEEENNNN")));
        System.out.println("-------------------------");
        System.out.println(Arrays.toString(t.solution("SSSSSSWWWNNNNNN")));

    }
}

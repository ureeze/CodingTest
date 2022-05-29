package Programmers.GREEDY;

import java.util.ArrayList;

public class Joystick {
    static ArrayList<Integer> resultList;

    public int solution(String name) {
        int count = 0;
        resultList = new ArrayList<>();
        long remainCnt = name.chars().filter(value -> value != 65).count();
        System.out.println(remainCnt);

        // 바꿀 것이 없는 경우
        if (remainCnt == 0) {
            return 0;
        }

        // 인덱스 0 가 A 인지 탐색
        if ('A' != name.charAt(0)) {
            count += moveAlphabet(name.charAt(0));
        }

        dfs(name, remainCnt, 0, count, "L");
        dfs(name, remainCnt, 0, count, "R");

        System.out.println(resultList);
        return 0;
    }

    private void dfs(String name, long remainCnt, int index, int total, String dir) {
        if (dir.equals("L")) {
            int cnt = name.length();
            int left = 0;
            while (cnt != 0) {
                cnt--;
                index--;
                left++;
                if (index == -1) {
                    index = name.length() - 1;
                }
                if (name.charAt(index) != 'A') {
                    break;
                }
            }
            total += left;
            remainCnt--;
        } else if (dir.equals("R")) {
            int cnt = name.length();
            int right = 0;
            while (cnt != 0) {
                cnt--;
                index++;
                right++;
                if (index == name.length()) {
                    index = 0;
                }
                if (name.charAt(index) != 'A') {
                    break;
                }
            }
            total += right;
            remainCnt--;
        }

        // index 가 A 인지 탐색
        if ('A' != name.charAt(index)) {
            total += moveAlphabet(name.charAt(index));
        }

        // 끝이면 값 저장
        if (remainCnt == 0) {
            resultList.add(total);
        }

        dfs(name, remainCnt, 0, total, "L");
        dfs(name, remainCnt, 0, total, "R");

    }

    private int moveAlphabet(char c) {
        int num1 = (int) c - 65;
        int num2 = 90 - (int) c + 1;
        return Math.min(num1, num2);
    }

    public static void main(String[] args) {
        Joystick j = new Joystick();
        System.out.println(j.solution("JEROEN"));
        System.out.println(j.solution("JAN"));
        System.out.println(j.solution("ABAAAAAAAAABB"));


    }
}

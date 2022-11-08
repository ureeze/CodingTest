package TOSS2022;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class TEST05 {
    public int solution(int[] tasks) {
        int answer = 0;
        Arrays.sort(tasks);
        List<Integer> list = Arrays.stream(tasks).boxed().collect(Collectors.toList());

        for (int i = 0; i < list.size(); i++) {
            if (i + 1 < list.size() && list.get(i) == list.get(i + 1)) {
                continue;
            } else {
                int len = Collections.frequency(list, list.get(i));
                int fq = len / 4 + 1;
                if (len == 1) {
                    //-1
                    return -1;
                } else {
                    answer += fq;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        TEST05 test05 = new TEST05();
        System.out.println(test05.solution(new int[]{1, 1, 2, 3, 3, 2, 2})); // 3
        System.out.println(test05.solution(new int[]{4, 1, 1, 1, 1, 2, 3})); // -1
        System.out.println(test05.solution(new int[]{1, 1, 2, 2})); // 2
    }
}
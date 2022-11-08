package TOSS2022;

import java.util.ArrayList;
import java.util.Arrays;

public class TEST02 {
    public int solution(int[] levels) {
        ArrayList<Integer> result = new ArrayList<>();
        Arrays.sort(levels);
        int len = levels.length;

        float num = (float) 100 / len;
        System.out.println(num);

        for (int i = 1; i <= levels.length; i++) {
            if (num * i <= 25) {
                result.add(levels[len - i]);
            } else {
                break;
            }
        }
        if (result.isEmpty()) {
            return -1;
        } else {
            return result.get(result.size() - 1);
        }
    }

    public static void main(String[] args) {
        TEST02 test02 = new TEST02();
        System.out.println(test02.solution(new int[]{1, 2, 3, 4})); // 4
        System.out.println(test02.solution(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9})); // 8
    }
}

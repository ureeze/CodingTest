package Programmers.KAKAO_BLIND_2018;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class Zip {
    public int[] solution(String msg) {
        int[] answer;
        ArrayList<Integer> result = new ArrayList<>();

        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 1; i <= 26; i++) {
            char c = (char) (i + 64);
            map.put(String.valueOf(c), i);
        }
        String[] arr = msg.split("");

        int index = 27;
        StringBuilder sb = new StringBuilder();
        for (int j = 0; j < arr.length; j++) {
            sb.append(arr[j]);
            if (j + 1 < arr.length) {
                if (map.containsKey(sb.toString() + arr[j + 1])) {
                    continue;
                } else {
                    // 사전 추가
                    map.put(sb.toString() + arr[j + 1], index++);
                    int val = map.get(sb.toString());
                    result.add(val);
                    sb = new StringBuilder();
                }
            } else {
                map.putIfAbsent(sb.toString(), index++);
                result.add(map.get(sb.toString()));
            }
        }

        answer = result.stream().mapToInt(Integer::intValue).toArray();

        return answer;
    }

    public static void main(String[] args) {
        Zip zip = new Zip();
        System.out.println(Arrays.toString(zip.solution("KAKAO")));
        System.out.println(Arrays.toString(zip.solution("TOBEORNOTTOBEORTOBEORNOT")));
        System.out.println(Arrays.toString(zip.solution("ABABABABABABABAB")));
    }
}

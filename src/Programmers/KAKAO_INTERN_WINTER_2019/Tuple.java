package Programmers.KAKAO_INTERN_WINTER_2019;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.StringTokenizer;

public class Tuple {
    public int[] solution(String s) {
        int[] answer;
        ArrayList<String> list = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();
        String str = s.substring(1, s.length() - 1);
        StringTokenizer st = new StringTokenizer(str, "{,}");

        while (st.hasMoreTokens()) {
            String element = st.nextToken();
            if (element != "{" && element != "}" && element != ",") {
                int num = Integer.parseInt(element);
                map.put(num, map.getOrDefault(num, 0) + 1);
            }
        }
        answer = map.entrySet()
                .stream()
                .sorted((o1, o2) -> o2.getValue() - o1.getValue())
                .map(integerIntegerEntry -> integerIntegerEntry.getKey())
                .mapToInt(Integer::intValue)
                .toArray();

        return answer;
    }

    public static void main(String[] args) {
        Tuple tuple = new Tuple();
        System.out.println(Arrays.toString(tuple.solution("{{2},{2,1},{2,1,3},{2,1,3,4}}")));
        System.out.println(Arrays.toString(tuple.solution("{{1,2,3},{2,1},{1,2,4,3},{2}}")));
        System.out.println(Arrays.toString(tuple.solution("{{20,111},{111}}")));
        System.out.println(Arrays.toString(tuple.solution("{{123}}")));
        System.out.println(Arrays.toString(tuple.solution("{{4,2,3},{3},{2,3,4,1},{2,3}}")));
    }
}

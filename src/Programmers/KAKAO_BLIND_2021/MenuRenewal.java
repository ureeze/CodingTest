package Programmers.KAKAO_BLIND_2021;

import java.util.*;
import java.util.stream.Collectors;

public class MenuRenewal {
    public String[] solution(String[] orders, int[] course) {
        String[] answer = {};
        List<String> result = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        boolean[] visited;
        for (int i = 0; i < orders.length; i++) {

            orders[i] = sorting(orders[i]);
            visited = new boolean[orders[i].length()];
            combination(orders[i], map, visited);
        }

        for (int i = 0; i < course.length; i++) {
            int len = course[i];
            int max = map.entrySet().stream()
                    .filter(stringIntegerEntry -> stringIntegerEntry.getKey().length() == len)
                    .filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 2)
                    .max((o1, o2) -> o1.getValue().compareTo(o2.getValue())).orElse(new Map.Entry<String, Integer>() {
                        @Override
                        public String getKey() {
                            return null;
                        }

                        @Override
                        public Integer getValue() {
                            return -1;
                        }

                        @Override
                        public Integer setValue(Integer value) {
                            return null;
                        }
                    }).getValue();
            if (max == -1) {
                continue;
            }
            List<String> list = map.entrySet().stream()
                    .filter(stringIntegerEntry -> stringIntegerEntry.getKey().length() == len)
                    .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == max)
                    .map(stringIntegerEntry -> stringIntegerEntry.getKey())
                    .collect(Collectors.toList());
            result.addAll(list);
        }
        result.sort(null);
        return result.toArray(new String[result.size()]);
    }

    private String sorting(String order) {
        char[] arr = order.toCharArray();
        Arrays.sort(arr);
        return new String(arr);
    }

    private void combination(String order, HashMap<String, Integer> map, boolean[] visited) {
        for (int i = 0; i < order.length(); i++) {
            visited[i] = true;
            dfs(i, order.charAt(i) + "", order, map, visited);
        }
    }

    private void dfs(int idx, String str, String order, HashMap<String, Integer> map, boolean[] visited) {
        if (str.length() >= 2 && str.length() <= order.length()) {
            map.put(str, map.getOrDefault(str, 0) + 1);
            if (idx == order.length() - 1) {
                return;
            }
        }
        for (int i = idx + 1; i < order.length(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(i, str + order.charAt(i), order, map, visited);
                visited[i] = false;
            }
        }
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(new MenuRenewal().solution(new String[]{"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"}, new int[]{2, 3, 4})));
        System.out.println(Arrays.toString(new MenuRenewal().solution(new String[]{"ABCDE", "AB", "CD", "ADE", "XYZ", "XYZ", "ACD"}, new int[]{2, 3, 5})));
        System.out.println(Arrays.toString(new MenuRenewal().solution(new String[]{"XYZ", "XWY", "WXA"}, new int[]{2, 3, 4})));
    }
}

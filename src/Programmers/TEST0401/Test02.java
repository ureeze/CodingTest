package Programmers.TEST0401;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class Test02 {
    public String solution(String call) {
        String answer = "";
        ArrayList<String> list2 = new ArrayList<>();
        List<String> list3 = new ArrayList<>();
        String lowerStr = call.toLowerCase();
        HashMap<String, Integer> map = new HashMap<>();
        HashMap<String, Integer> map2 = new HashMap<>();
        char[] arr = lowerStr.toCharArray();
        for (char c : arr) {
            map.put(c + "", map.getOrDefault(c + "", 0) + 1);
        }
        int max = map.values().stream().max((o1, o2) -> o1 - o2).get();
        List<String> list1 = map.entrySet().stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == max)
                .map(stringIntegerEntry -> stringIntegerEntry.getKey())
                .collect(Collectors.toList());

        boolean[] visited = new boolean[list1.size()];
        for (int i = 0; i < list1.size(); i++) {
            visited[i] = true;
            dfs(list1.get(i), list1, visited, list2);
            visited[i] = false;
        }
        int max2 = 0;
        for (String s : list2) {
            int count = (lowerStr.length() - Arrays.stream(lowerStr.split(s)).collect(Collectors.joining()).length()) / s.length();
            map2.put(s, count);
            if (max2 < count) {
                max2 = count;
            }
        }
        int finalMax = max2;
        list3 = map2.entrySet()
                .stream()
                .filter(stringIntegerEntry -> stringIntegerEntry.getValue() == finalMax)
                .map(stringIntegerEntry -> stringIntegerEntry.getKey())
                .sorted((o1, o2) -> o2.length() - o1.length())
                .collect(Collectors.toList());
        int len = list3.get(0).length();
        list3 = list3.stream()
                .filter(s -> s.length() == len)
                .collect(Collectors.toList());

        for (String s : list3) {
            lowerStr = lowerStr.replaceAll(s, "");
        }
        return lowerStr;
    }


    private void dfs(String str, List<String> list1, boolean[] visited, ArrayList<String> list2) {
        if (str.length() <= list1.size()) {
            list2.add(str);
        }
        for (int i = 0; i < list1.size(); i++) {
            if (!visited[i]) {
                visited[i] = true;
                String nextStr = str + list1.get(i);
                dfs(nextStr, list1, visited, list2);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Test02 test02 = new Test02();
        System.out.println(test02.solution("abcabcdefabc"));
        System.out.println("===================");
        System.out.println(test02.solution("abxdeydeabz"));
        System.out.println("===================");
        System.out.println(test02.solution("abcabca"));
        System.out.println("===================");
        System.out.println(test02.solution("ABCabcA"));
        System.out.println("===================");
    }
}

package Programmers.KAKAO_BLIND_2018;

import java.util.*;
import java.util.stream.Collectors;

public class NewsClustering {
    public int solution(String str1, String str2) {
        int answer = 0;
        ArrayList<String> list1 = new ArrayList<>();
        ArrayList<String> list2 = new ArrayList<>();
        ArrayList<String> listx = new ArrayList<>();
        ArrayList<String> listu = new ArrayList<>();

        multiCollection(str1, list1);
        multiCollection(str2, list2);

        HashMap<String, Integer> hashMap = new HashMap<>();

        for (String s : list1) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }
        for (String s : list2) {
            hashMap.put(s, hashMap.getOrDefault(s, 0) + 1);
        }

        List<String> minList;
        Set<String> maxSet;

        minList = hashMap.entrySet().stream().filter(stringIntegerEntry -> stringIntegerEntry.getValue() >= 2)
                .map(stringIntegerEntry -> stringIntegerEntry.getKey()).collect(Collectors.toList());
        maxSet = hashMap.keySet();


        for (String searchWord : minList) {
            long count1 = list1.stream().filter(s -> s.equals(searchWord)).count();
            long count2 = list2.stream().filter(s -> s.equals(searchWord)).count();
            long minCount = Math.min(count1, count2);
            for (int i = 0; i < minCount; i++) {
                listx.add(searchWord);
            }
        }

        for (String searchWord : maxSet) {
            long count1 = list1.stream().filter(s -> s.equals(searchWord)).count();
            long count2 = list2.stream().filter(s -> s.equals(searchWord)).count();
            long maxCount = Math.max(count1, count2);
            for (int i = 0; i < maxCount; i++) {
                listu.add(searchWord);
            }
        }


        if (listx.size() == 0 && listu.size() == 0) {
            answer = 65536;
        } else {
            float num1 = (float) ((float) listx.size() / (float) listu.size()) * 65536;
            answer = (int) num1;
        }

        return answer;
    }

    private void multiCollection(String str1, ArrayList<String> list) {
        String str = str1.toUpperCase();
        for (int i = 0; i < str.length() - 1; i++) {
            int num1 = str.charAt(i);
            int num2 = str.charAt(i + 1);
            if (checkNum(num1) && checkNum(num2)) {
                list.add(str.substring(i, i + 2));
            }
        }
    }

    private boolean checkNum(int num) {
        if (num >= 65 && num <= 90) {
            return true;
        }
        return false;
    }


    public static void main(String[] args) {
        NewsClustering newsClustering = new NewsClustering();
        System.out.println(newsClustering.solution("FRANCE", "french"));
        System.out.println(newsClustering.solution("handshake", "shake hands"));
        System.out.println(newsClustering.solution("aa1+aa2", "AAAA12"));
        System.out.println(newsClustering.solution("E=M*C^2", "e=m*c^2"));
    }
}

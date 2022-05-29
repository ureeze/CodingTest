package SSG;

import java.util.*;

public class TEST2 {
    public String[] solution(String[] logs) {
        String[] answer;
        Set<String> answerSet = new HashSet<>();
        StringTokenizer st;
        Map<Integer, Map<Integer, Integer>> map = new HashMap<>();
        for (int i = 0; i < logs.length; i++) {
            String s = logs[i];
            st = new StringTokenizer(s);
            int examId = Integer.parseInt(st.nextToken());
            int problemNo = Integer.parseInt(st.nextToken());
            int score = Integer.parseInt(st.nextToken());

            if (!map.containsKey(examId)) {
                map.put(examId, new HashMap<>());
            }
            map.get(examId).put(problemNo, score);
        }
        Queue<Integer> queue = new LinkedList<>(map.keySet());
        for (int i = 0; i < queue.size(); i++) {
            int examId = queue.poll();
            Map<Integer, Integer> map1 = map.get(examId);
            int count = map.get(examId).size();
            Iterator<Integer> iterator = queue.iterator();
            while (iterator.hasNext()) {
                int nextId = iterator.next();
                int nextCnt = map.get(nextId).size();
                if (nextCnt < 5) {
                    continue;
                }
                if (count == nextCnt) {
                    Map<Integer, Integer> map2 = map.get(nextId);
                    boolean flag = compare(map1, map2);
                    if (flag) {
                        answerSet.add(String.format("%04d", examId));
                        answerSet.add(String.format("%04d", nextId));
                    }
                } else {
                    continue;
                }
            }
        }
        if (answerSet.size() != 0) {
            answer = new String[answerSet.size()];
        } else {
            answer = new String[1];
            answer[0]= "None";
            return answer;
        }

        int index = 0;
        for (String s : answerSet) {
            answer[index] = s;
            index++;
        }
        Arrays.sort(answer);
        return answer;
    }

    private boolean compare(Map<Integer, Integer> map1, Map<Integer, Integer> map2) {
        ArrayList<Integer> list1 = new ArrayList<>(map1.keySet());
        ArrayList<Integer> list2 = new ArrayList<>(map2.keySet());
        list1.sort(null);
        list2.sort(null);
        for (int i = 0; i < list1.size(); i++) {
            int idx1 = list1.get(i);
            int idx2 = list2.get(i);
            if (idx1 != idx2) {
                return false;
            }
            if (map1.get(idx1) != map2.get(idx2)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        TEST2 t = new TEST2();
        System.out.println(Arrays.toString(t.solution(new String[]{"0001 3 95", "0001 5 90", "0001 5 100", "0002 3 95", "0001 7 80", "0001 8 80", "0001 10 90", "0002 10 90", "0002 7 80", "0002 8 80", "0002 5 100", "0003 99 90"})));
        System.out.println(Arrays.toString(t.solution(new String[]{"1901 1 100", "1901 2 100", "1901 4 100", "1901 7 100", "1901 8 100", "1902 2 100", "1902 1 100", "1902 7 100", "1902 4 100", "1902 8 100", "1903 8 100", "1903 7 100", "1903 4 100", "1903 2 100", "1903 1 100", "1101 1 95", "1101 2 100", "1101 4 100", "1101 7 100", "1101 9 100", "1102 1 95", "1102 2 100", "1102 4 100", "1102 7 100", "1102 9 100"})));
        System.out.println(Arrays.toString(t.solution(new String[]{"1901 10 50", "1909 10 50"})));
        System.out.println(Arrays.toString(t.solution(new String[]{"0001 1 0", "0001 2 0", "0001 3 0", "0001 4 0", "0001 5 0", "0456 1 0", "0456 2 0", "0456 3 0", "0456 4 0", "0456 5 0"})));
    }
}

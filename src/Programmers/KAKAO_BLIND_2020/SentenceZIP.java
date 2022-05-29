package Programmers.KAKAO_BLIND_2020;

public class SentenceZIP {
    public int solution(String s) {
        int answer = s.length();

        for (int i = 1; i <= s.length() / 2; i++) {
            StringBuilder sb = new StringBuilder();
            String prev = s.substring(0, i);
            int zipLevel = 1;

            for (int idx = i; idx <= s.length(); idx += i) {
                String next = s.substring(idx, idx + i > s.length() ? s.length() : idx + i);
                if (prev.equals(next)) {
                    zipLevel++;
                } else {
                    sb.append(zipLevel != 1 ? zipLevel : "").append(prev);
                    zipLevel = 1;
                    prev = next;
                }
            }
            sb.append(prev);
            answer = Math.min(answer, sb.length());
        }


        return answer;
    }

    public static void main(String[] args) {
        SentenceZIP s = new SentenceZIP();
        System.out.println(s.solution("aabbaccc"));
        System.out.println(s.solution("ababcdcdababcdcd"));
        System.out.println(s.solution("abcabcdede"));
        System.out.println(s.solution("abcabcabcabcdededededede"));
        System.out.println(s.solution("xababcdcdababcdcd"));
    }
}

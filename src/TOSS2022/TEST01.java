package TOSS2022;


public class TEST01 {
    public int solution(String s) {
        int answer = 0;
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i + 1 < s.length() && s.charAt(i) == s.charAt(i + 1)) {
                cnt++;
                continue;
            } else {

            }
        }

        return answer;
    }

    public static void main(String[] args) {
        TEST01 test01 = new TEST01();
        System.out.println(test01.solution("12223")); // 222
        System.out.println(test01.solution("111999333")); // 999
        System.out.println(test01.solution("123")); // -1
    }
}

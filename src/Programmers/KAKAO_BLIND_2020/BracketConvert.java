package Programmers.KAKAO_BLIND_2020;

import java.util.Stack;

public class BracketConvert {
    public String solution(String p) {
        char[] arr = p.toCharArray();
        String answer = checkStr(p);
        return answer;
    }

    private String checkStr(String str) {
        if (str.length() == 0) {
            return "";
        }
        int left = 0, right = 0;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                left++;
            } else if (c == ')') {
                right++;
            }

            if (left == right) {
                //균형
                String u = str.substring(0, i + 1);
                if (checkCorrect(u)) {
                    //올
                    return u + checkStr(str.substring(i + 1));
                } else {
                    //비올
                    int len = u.length();
                    String reverseStr = strReverse(u);
                    return "(" + checkStr(str.substring(i + 1)) + ")" + reverseStr;
                }
            }
        }
        return str;
    }

    private String strReverse(String u) {
        StringBuilder sb = new StringBuilder(u);
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '(') {
                sb.setCharAt(i, ')');
            } else {
                sb.setCharAt(i, '(');
            }
        }
        return sb.substring(1, u.length() - 1);
    }

    private boolean checkCorrect(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    stack.pop();
                }
            }
        }
        return true;
    }


    public static void main(String[] args) {
        BracketConvert b = new BracketConvert();
        System.out.println(b.solution("(()())()"));
        System.out.println(b.solution(")("));
        System.out.println(b.solution("()))((()"));
    }
}

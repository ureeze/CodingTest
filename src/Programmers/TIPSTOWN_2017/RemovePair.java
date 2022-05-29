package Programmers.TIPSTOWN_2017;

import java.util.Stack;

public class RemovePair {
    public int solution(String s) {
        Stack<Character> stack1 = new Stack<>();
        Stack<Character> stack2 = new Stack<>();

        for (int i = s.length() - 1; i >= 0; i--) {
            stack1.push(s.charAt(i));
        }

        while (!stack1.isEmpty()) {
            Character c1 = stack1.pop();
            if (!stack2.isEmpty()) {
                Character c2 = stack2.peek();
                if (c1 == c2) {
                    stack2.pop();
                } else {
                    stack2.push(c1);
                }
            } else {
                stack2.push(c1);
            }
        }
        return stack2.size() == 0 ? 1 : 0;
    }


    public static void main(String[] args) {
        RemovePair removePair = new RemovePair();
        System.out.println(removePair.solution("baabaa"));
        System.out.println(removePair.solution("cdcd"));
    }
}

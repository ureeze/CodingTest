package Programmers.KAKAO_INTERN_2020;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class ExpressionMax {
    public long solution(String expression) {
        List<String> list = new ArrayList<>();
        List<String> list2;
        StringTokenizer st = new StringTokenizer(expression, "-*+", true);
        while (st.hasMoreTokens()) {
            list.add(st.nextToken());
        }
        String[][] operatorArr = {{"*", "+", "-"}, {"*", "-", "+"}, {"-", "*", "+"}, {"-", "+", "*"}, {"+", "*", "-"}, {"+", "-", "*"}};
        long max = 0;

        for (int i = 0; i < operatorArr.length; i++) {
            String operator;
            operator = operatorArr[i][0];
            list2 = new ArrayList<>(list);
            list2 = check(operator, list2);

            operator = operatorArr[i][1];
            list2 = check(operator, list2);

            operator = operatorArr[i][2];
            list2 = check(operator, list2);

            max = Math.max(max, Math.abs(Long.parseLong((list2.get(0)))));
        }
        return max;
    }

    private List<String> check(String operator, List<String> list) {
        long result = 0;
        int len = list.size();
        for (int i = 1; i < len; i = i + 2) {
            if (list.get(i).equals(operator)) {
                long prevNum = Long.parseLong(list.get(i - 1));
                long postNum = Long.parseLong(list.get(i + 1));

                switch (operator) {
                    case "*":
                        result = prevNum * postNum;
                        break;
                    case "+":
                        result = prevNum + postNum;
                        break;
                    case "-":
                        result = prevNum - postNum;
                        break;
                }
                list.remove(i + 1);
                if (result < 0) {
                    list.set(i, "-" + String.valueOf(Math.abs(result)));
                } else {
                    list.set(i, String.valueOf(result));
                }
                list.remove(i - 1);
                len -= 2;
                i -= 2;
            }
        }
        return list;
    }

    public static void main(String[] args) {
        ExpressionMax expressionMax = new ExpressionMax();
        System.out.println(expressionMax.solution("100-200*300-500+20"));
        System.out.println("==========================================");
        System.out.println(expressionMax.solution("50*6-3*2"));
    }
}

package Programmers.sort;

import java.util.*;
import java.util.stream.Collectors;

public class MostNumber {
    public String solution(int[] numbers) {
        List<String> list = Arrays
                .stream(numbers)
                .boxed()
                .map(integer -> String.valueOf(integer))
                .sorted((o1, o2) -> (o2 + o1).compareTo(o1 + o2))
                .collect(Collectors.toList());
        StringBuilder sb = new StringBuilder();
        for (String s :
                list) {
            sb.append(s);
        }
        return sb.toString().charAt(0) == '0' ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        MostNumber m = new MostNumber();
        System.out.println(m.solution(new int[]{3, 30, 34, 5, 9}));
        System.out.println(m.solution(new int[]{6, 10, 2}));
        System.out.println(m.solution(new int[]{0, 0, 0}));
    }
}

package Programmers.TEST0401;

import java.util.ArrayList;
import java.util.HashMap;

public class Test03 {
    public String solution(String tstring, String[][] variables) {
        String answer = "";
        HashMap<String, String> map = new HashMap<>();

        ArrayList<String> list = new ArrayList<>();
        for (int i = 0; i < variables.length; i++) {
            list.add(variables[i][0]);
            map.put(variables[i][0], variables[i][1]);
        }
        String[][] newarr = variables;
        for (int i = 0; i < variables.length; i++) {
            String curVal = variables[i][1];
            if (curVal.charAt(0) == '{') {
                String subVal = curVal.substring(1, curVal.length() - 1);
                if (map.get(subVal) != null) {

                } else {
                    String nextKey = map.get(subVal);

                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        Test03 t = new Test03();
        System.out.println(t.solution("this is {template} {template} is {state}",
                new String[][]{{"template", "string"}, {"state", "changed"}}));
        System.out.println(t.solution("this is {template} {template} is {state}",
                new String[][]{{"template", "string"}, {"state", "{template}"}}));
        System.out.println(t.solution("this is {template} {template} is {state}",
                new String[][]{{"template", "{state}"}, {"state", "{template}"}}));
        System.out.println(t.solution("this is {template} {template} is {state}",
                new String[][]{{"template", "{state}"}, {"state", "{templates}"}}));
        System.out.println(t.solution("{a} {b} {c} {d} {i}",
                new String[][]{{"b", "{c}"}, {"a", "{b}"}, {"e", "{f}"}, {"h", "i"}, {"d", "{e}"}, {"f", "{d}"}, {"c", "d"}}));
    }
}

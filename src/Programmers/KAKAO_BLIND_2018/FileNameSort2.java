package Programmers.KAKAO_BLIND_2018;

import java.util.ArrayList;
import java.util.Arrays;

public class FileNameSort2 {
    public String[] solution(String[] files) {
        String[] answer;
        ArrayList<String> list = new ArrayList<>(Arrays.asList(files));

        list.sort((o1, o2) -> {
            String head1 = o1.split("[0-9]+")[0].toUpperCase();
            String head2 = o2.split("[0-9]+")[0].toUpperCase();
            int result = head1.compareTo(head2);
            if (result == 0) {
//                int num1 = convertNum(o1, head1);
//                int num2 = convertNum(o2, head2);
                int num1 = Integer.parseInt(o1.split("[\\D]+")[1]);
                int num2 = Integer.parseInt(o2.split("[\\D]+")[1]);

                return num1 - num2;

            } else {
                return result;
            }
        });
        answer = list.toArray(new String[list.size()]);
        return answer;
    }

    private int convertNum(String str, String head) {
        str = str.substring(head.length());
        StringBuilder result = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (Character.isDigit(c) && result.length() < 5) {
                result.append(c);
            } else {
                break;
            }
        }
        return Integer.parseInt(result.toString());

    }


    public static void main(String[] args) {
        FileNameSort2 f = new FileNameSort2();
        System.out.println(Arrays.toString(f.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(f.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

}

package Programmers.KAKAO_BLIND_2018;

import java.util.ArrayList;
import java.util.Arrays;

public class FileNameSort {
    public String[] solution(String[] files) {
        String[] answer;
        ArrayList<File> list = new ArrayList<>();
        check(list, files);

        answer = list.stream().sorted((o1, o2) -> {
            if (o1.head.compareTo(o2.head) == 0) {
                if (o1.number < o2.number) {
                    return o1.number - o2.number;
                } else if (o1.number < o2.number) {
                    return o2.number - o1.number;
                } else {
                    return o1.index - o2.index;
                }
            }
            return o1.head.compareTo(o2.head);
        }).map(file -> file.fullName).toArray(String[]::new);
        return answer;
    }

    private void check(ArrayList<File> list, String[] files) {
        for (int i = 0; i < files.length; i++) {
            String head = "";
            String number = "";
            String tail = "";
            char[] arr = files[i].toUpperCase().toCharArray();
            StringBuilder sb = new StringBuilder();
            boolean headFlag = false;
            boolean numFlag = false;

            for (int j = 0; j < arr.length; j++) {
                char c = arr[j];
                int cNum = (int) c;
                if ((cNum >= 65 && cNum <= 90) || (cNum >= 45 && cNum <= 46) || cNum == 32) {
                    //문자 입력
                    if (!headFlag) {
                        //헤드 존재x
                        sb.append(c);
                    } else {
                        //헤드 존재
                        if (!numFlag) {
                            numFlag = true;
                            number = sb.toString(); // 숫자입력
                            sb = new StringBuilder(); // 꼬리 시작
                            sb.append(arr, j, arr.length - j);
                            tail = sb.toString();
                            break;
                        }

                    }
                } else {
                    //숫자입력
                    if (!headFlag) {
                        //헤드 존재x
                        head = sb.toString(); //헤드 입력
                        headFlag = true;
                        sb = new StringBuilder();
                        sb.append(c); //숫자 시작
                    } else {
                        //헤드 존재
                        if (!numFlag) {
                            //숫자 존재x
                            sb.append(c);
                        } else {
                            //숫자 존재
                            //마무리
                            sb.append(arr, j, arr.length - j);
                            tail = sb.toString();
                            break;
                        }
                    }
                }
            }
//            System.out.println("head=" + head + ", number=" + number + ", tail=" + tail);
            list.add(new File(i, head, Integer.parseInt(number), tail, files[i]));

        }
    }

    public static void main(String[] args) {
        FileNameSort f = new FileNameSort();
        System.out.println(Arrays.toString(f.solution(new String[]{"img12.png", "img10.png", "img02.png", "img1.png", "IMG01.GIF", "img2.JPG"})));
        System.out.println(Arrays.toString(f.solution(new String[]{"F-5 Freedom Fighter", "B-50 Superfortress", "A-10 Thunderbolt II", "F-14 Tomcat"})));
    }

}

class File {
    int index;
    String head;
    int number;
    String tail;
    String fullName;

    public File(int index, String head, int number, String tail, String fullName) {
        this.index = index;
        this.head = head;
        this.number = number;
        this.tail = tail;
        this.fullName = fullName;
    }

    @Override
    public String toString() {
        return "File{" +
                "index=" + index +
                ", head='" + head + '\'' +
                ", number=" + number +
                ", tail='" + tail + '\'' +
                ", fullName='" + fullName + '\'' +
                '}';
    }
}
package Programmers.KAKAO_BLIND_2018;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class JustThisSong {
    public String solution(String m, String[] musicinfos) {
        StringTokenizer st;
        StringBuilder sb;
        ArrayList<Node3> list = new ArrayList<>();
        for (int i = 0; i < musicinfos.length; i++) {
            st = new StringTokenizer(musicinfos[i], ",:");
            int totalBun = calculTime(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            String title = st.nextToken();
            String infoStr = updateInfo(st.nextToken());

            if (totalBun <= infoStr.length()) {
                infoStr = infoStr.substring(0, totalBun);
            } else {
                sb = new StringBuilder();
                double val = Math.ceil(totalBun / (double) infoStr.length());
                for (int j = 0; j < val; j++) {
                    sb.append(infoStr);
                }
                infoStr = sb.toString();
            }
            list.add(new Node3(i, totalBun, title, infoStr));
        }
        System.out.println(list);

        String mStr = updateInfo(m);
        list.removeIf(node -> !node.info.contains(mStr));
        if (list.size() > 1) {
            list.sort((o1, o2) -> {
                if (o1.totalBun == o2.totalBun) {
                    return o1.index - o2.index;
                }
                return o2.totalBun - o1.totalBun;
            });
        }
        if (list.isEmpty()) {
            return "(None)";
        } else {
            return list.get(0).title;
        }
    }

    private int calculTime(int startSi, int startBun, int endSi, int endBun) {
        return endSi * 60 + endBun - (startSi * 60 + startBun);
    }


    private String updateInfo(String info) {
        LinkedList<String> list = new LinkedList<>();
        for (String s : info.split("")) {
            if (s.equals("#")) {
                String str = list.pollLast().toLowerCase();
                list.add(str);
            } else {
                list.add(s);
            }
        }
        return list.stream().collect(Collectors.joining());
    }

    public static void main(String[] args) {
        JustThisSong j = new JustThisSong();
        System.out.println(j.solution("ABCDEFG",
                new String[]{"12:00,12:14,HELLO,CDEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(j.solution("CC#BCC#BCC#BCC#B",
                new String[]{"03:00,03:30,FOO,CC#B", "04:00,04:08,BAR,CC#BCC#BCC#B"}));
        System.out.println(j.solution("ABC",
                new String[]{"12:00,12:14,HELLO,C#DEFGAB", "13:00,13:05,WORLD,ABCDEF"}));
        System.out.println(j.solution("A#",
                new String[]{"12:00,12:01,HELLO,A#"}));

    }
}

class Node3 {
    int index;
    int totalBun;
    String title;
    String info;

    public Node3(int index, int totalBun, String title, String info) {
        this.index = index;
        this.totalBun = totalBun;
        this.title = title;
        this.info = info;
    }

    @Override
    public String toString() {
        return "Node3{" +
                "index=" + index +
                ", totalBun=" + totalBun +
                ", title='" + title + '\'' +
                ", info='" + info + '\'' +
                '}';
    }
}
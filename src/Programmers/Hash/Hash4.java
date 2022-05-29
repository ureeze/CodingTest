package Programmers.Hash;

import java.util.*;
import java.util.stream.Collectors;

public class Hash4 {
    public int[] solution(String[] genres, int[] plays) {
        HashMap<String, Integer> map = new HashMap<>();
        int len = genres.length;
        for (int i = 0; i < len; i++) {
            map.put(genres[i], map.getOrDefault(genres[i], 0) + plays[i]);
        }
        List<Map.Entry<String, Integer>> list = new ArrayList<>(map.entrySet());
        list.sort((o1, o2) -> o2.getValue() - o1.getValue());

         ArrayList<Node> nodes = new ArrayList<>();
        for (int i = 0; i < len; i++) {
            Node node = new Node(i, genres[i], plays[i]);
            nodes.add(node);
        }

        List<Integer> result = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            int finalI = i;
            List<Integer> filterIndexs = nodes.stream()
                    .filter(node -> node.getGenre().equals(list.get(finalI).getKey()))
                    .sorted((o1, o2) -> {
                        if (o1.getPlay() == o2.getPlay()) {
                            return o1.getIndex() - o2.getIndex();
                        }
                        return o2.getPlay() - o1.getPlay();
                    })
                    .map(node -> node.getIndex())
                    .collect(Collectors.toList());

//            System.out.println("filterIdxs:" + filterIndexs.toString());

            if (filterIndexs.size() == 1) {
                result.addAll(filterIndexs);
//                System.out.println("result:" + result);
            } else {
                result.addAll(filterIndexs.subList(0, 2));
//                System.out.println("result:" + result);
            }
        }
        return result.stream().mapToInt(value -> value).toArray();

    }

    public static void main(String[] args) {
        Hash4 hash4 = new Hash4();
        System.out.println(Arrays.toString(
                hash4.solution(
                        new String[]{"classic", "pop", "classic", "classic", "pop"},
                        new int[]{500, 600, 150, 800, 2500})));
    }

}

class Node {
    int index;
    String genre;
    int play;

    public Node(int index, String genre, int play) {
        this.index = index;
        this.genre = genre;
        this.play = play;
    }

    public int getIndex() {
        return index;
    }

    public String getGenre() {
        return genre;
    }

    public int getPlay() {
        return play;
    }
}

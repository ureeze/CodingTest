package Programmers.BFSDFS;

import java.util.LinkedList;
import java.util.Queue;

public class WordChange {
    static int[] count;
    static boolean[] visited;

    public int solution(String begin, String target, String[] words) {
        count = new int[words.length];
        visited = new boolean[words.length];


        bfs(begin, words, target);

        return 0;
    }

    private void bfs(String begin, String[] words, String target) {
        Queue<Node2> queue = new LinkedList<>();
        queue.add(new Node2(begin, 0));

        while (!queue.isEmpty()) {
            Node2 node2 = queue.poll();

            for (int i = 0; i < words.length; i++) {
                if (!visited[i] && checkWord(node2.word, words[i])) {
                    visited[i] = true;
                    count[i] = node2.count + 1;
                    if (words[i].equals(target)) {
                        break;
                    }
                    queue.add(new Node2(words[i], node2.count + 1));
                }
            }
        }
    }

    private boolean checkWord(String word, String word1) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == word1.charAt(i)) {
                count++;
            }
        }
        return count == 2 ? true : false;
    }

    public static void main(String[] args) {
        WordChange w = new WordChange();
        System.out.println(w.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"}));
        System.out.println(w.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log"}));
    }
}

class Node2 {
    String word;
    int count;

    public Node2(String word, int count) {
        this.word = word;
        this.count = count;
    }
}
package Programmers.KAKAO_BLIND_2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class SearchRank {
    public int[] solution(String[] info, String[] query) {
        int[] answer = {};
        HashMap<String, ArrayList<Integer>> map = new HashMap<>();
        for (int i = 0; i < info.length; i++) {
            dfs("", info[i].split(""), 0, map);
        }

        return answer;
    }

    private void dfs(String str, String[] split, int depth, HashMap<String, ArrayList<Integer>> map) {
        if (depth == 4) {

        }
    }


    public static void main(String[] args) {
        SearchRank searchRank = new SearchRank();
        System.out.println(Arrays.toString(searchRank.solution(new String[]{"java backend junior pizza 150", "python frontend senior chicken 210", "python frontend senior chicken 150", "cpp backend senior pizza 260", "java backend junior chicken 80", "python backend senior chicken 50"}, new String[]{"java and backend and junior and pizza 100", "python and frontend and senior and chicken 200", "cpp and - and senior and pizza 250", "- and backend and senior and - 150", "- and - and - and chicken 100", "- and - and - and - 150"})));
    }
}


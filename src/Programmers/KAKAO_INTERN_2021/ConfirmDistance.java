package Programmers.KAKAO_INTERN_2021;

import java.util.*;

public class ConfirmDistance {
    public int[] solution(String[][] places) {
        ArrayList<Integer> answer;
        answer = new ArrayList<>();
        char[][] arr;
        for (String[] readyPlace : places) {
            boolean flag = true;
            arr = new char[5][5];
            for (int k = 0; k < places.length; k++) {
                arr[k] = readyPlace[k].toCharArray();
            }

            for (int i = 0; i < arr.length; i++) {
                for (int j = 0; j < arr[0].length; j++) {
                    if (arr[i][j] == 'P') {
                        // 상하좌우1칸 P 탐색
                        if (!checkLRUD1(i, j, arr)) {
                            flag = false;
                            break;
                        }
                        // 상하좌우2칸 P 탐색
                        if (!checkLRUD2(i, j, arr)) {
                            flag = false;
                            break;
                        }
                        // 대각선 P 탐색
                        if (!checkDiagonal(i, j, arr)) {
                            flag = false;
                            break;
                        }
                    }
                }
            }
            if (flag) {
                answer.add(1);
            } else {
                answer.add(0);
            }
        }
        return answer.stream().mapToInt(Integer::intValue).toArray();
    }

    private boolean checkLRUD2(int i, int j, char[][] arr) {
        int[] dx = {-2, 2, 0, 0};
        int[] dy = {0, 0, -2, 2};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] == 'P') {
                int ax = (nx + i) / 2;
                int ay = (ny + j) / 2;
                if (ax >= 0 && ay >= 0 && ax < 5 && ay < 5 && arr[ax][ay] == 'X') {
                    return true;
                }
                return false;
            }
        }
        return true;
    }

    private boolean checkDiagonal(int i, int j, char[][] arr) {
        int[] dx = {-1, -1, 1, 1};
        int[] dy = {-1, 1, -1, 1};
        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] == 'P') {
                if (nx >= 0 && j >= 0 && nx < 5 && j < 5 && arr[nx][j] == 'X' && i >= 0 && ny >= 0 && i < 5 && ny < 5 && arr[i][ny] == 'X') {
                    return true;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkLRUD1(int i, int j, char[][] arr) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        for (int k = 0; k < 4; k++) {
            int nx = i + dx[k];
            int ny = j + dy[k];
            if (nx >= 0 && ny >= 0 && nx < 5 && ny < 5 && arr[nx][ny] == 'P') {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        ConfirmDistance c = new ConfirmDistance();
        System.out.println(Arrays.toString(c.solution(new String[][]{
                {"POOOP", "OXXOX", "OPXPX", "OOXOX", "POXXP"},
                {"POOPX", "OXPXP", "PXXXO", "OXXXO", "OOOPP"},
                {"PXOPX", "OXOXP", "OXPOX", "OXXOP", "PXPOX"},
                {"OOOXX", "XOOOX", "OOOXX", "OXOOX", "OOOOO"},
                {"PXPXP", "XPXPX", "PXPXP", "XPXPX", "PXPXP"}})));
    }

}

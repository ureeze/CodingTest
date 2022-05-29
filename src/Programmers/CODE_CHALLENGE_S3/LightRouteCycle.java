package Programmers.CODE_CHALLENGE_S3;

import java.util.Arrays;

public class LightRouteCycle {
    public int[] solution(String[] grid) {
        int[] answer = {};
        int row = grid.length;
        int col = grid[0].length();
        boolean[][][] visited = new boolean[4][row][col];
        char[][] map = new char[row][col];
        for (int i = 0; i < grid.length; i++) {
            map[i] = grid[i].toCharArray();
        }


        return answer;
    }

    public static void main(String[] args) {
        LightRouteCycle l = new LightRouteCycle();
        System.out.println(Arrays.toString(l.solution(new String[]{"SL", "LR"})));
        System.out.println(Arrays.toString(l.solution(new String[]{"S"})));
        System.out.println(Arrays.toString(l.solution(new String[]{"R", "R"})));


//        int[][][] arr = new int[4][2][2];
//        arr[0][0][0] = 6;
//        arr[1][0][0] = 7;
//        arr[2][0][0] = 8;
//        arr[3][0][0] = 9;
//
//        for (int i = 0; i < arr.length; i++) {
//            for (int j = 0; j < arr[0].length; j++) {
//                for (int k = 0; k < arr[0][0].length; k++) {
//                    System.out.print(arr[i][j][k]);
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
    }
}

package BaekJoon.Realization;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Wheel14891 {
    static int[][] wheel;
    static int[] d;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        wheel = new int[4][8];
        for (int i = 0; i < 4; i++) {
            String s = br.readLine();
            for (int j = 0; j < 8; j++) {
                wheel[i][j] = Character.getNumericValue(s.charAt(j));
            }
        }
        int k = Integer.parseInt(br.readLine());
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken()) - 1;
            int dir = Integer.parseInt(st.nextToken());
            d = new int[4];
            d[num] = dir;
            wheelCheck(num);
            rotate();
        }
        int result = sum();
        System.out.println(result);
    }

    private static void wheelCheck(int num) {
        for (int i = num + 1; i <= 3; i++) {
            if (wheel[i - 1][2] != wheel[i][6]) {
                d[i] = -d[i - 1];
            } else {
                break;
            }
        }
        for (int i = num - 1; i >= 0; i--) {
            if (wheel[i + 1][6] != wheel[i][2]) {
                d[i] = -d[i + 1];
            } else {
                break;
            }
        }
    }

    private static int sum() {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            if (wheel[i][0] == 1) {
                sum += Math.pow(2, i);
            }
        }
        return sum;
    }

    private static void rotate() {
        for (int i = 0; i < d.length; i++) {
            int dir = d[i];
            if (dir == 1) {
                rightShift(i);
            } else if (dir == -1) {
                leftShift(i);
            }
        }
    }

    private static void leftShift(int num) {
        int temp = wheel[num][0];
        for (int i = 0; i < 7; i++) {
            wheel[num][i] = wheel[num][i + 1];
        }
        wheel[num][7] = temp;
    }

    private static void rightShift(int num) {
        int temp = wheel[num][7];
        for (int i = 7; i > 0; i--) {
            wheel[num][i] = wheel[num][i - 1];
        }
        wheel[num][0] = temp;
    }

}

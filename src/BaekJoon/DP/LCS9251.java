package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class LCS9251 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String s1 = br.readLine();
        String s2 = br.readLine();

        String[] c1 = new String[s1.length() + 1];
        String[] c2 = new String[s2.length() + 1];

        arrSetting(c1, s1);
        arrSetting(c2, s2);

        int[][] dp = new int[s1.length() + 1][s2.length() + 1];

        for (int i = 0; i < c1.length; i++) {
            for (int j = 0; j < c2.length; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else {
                    if (c1[i].equals(c2[j])) {
                        dp[i][j] = dp[i - 1][j - 1] + 1;
                    } else {
                        dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                    }
                }
            }
        }
        System.out.println(dp[c1.length - 1][c2.length - 1]);


    }

    private static void arrSetting(String[] arr, String s) {
        for (int i = 0; i <= s.length(); i++) {
            if (i == 0) {
                arr[i] = "0";
            } else {
                arr[i] = String.valueOf(s.charAt(i - 1));
            }
        }
    }
}

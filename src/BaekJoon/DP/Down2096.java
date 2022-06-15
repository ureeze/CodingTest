package BaekJoon.DP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Down2096 {
    static int N;
    static int[] minDp, maxDp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        StringTokenizer st;
        maxDp = new int[3];
        minDp = new int[3];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int a0 = Integer.parseInt(st.nextToken());
            int a1 = Integer.parseInt(st.nextToken());
            int a2 = Integer.parseInt(st.nextToken());

            if (i == 0) {
                maxDp[0] = minDp[0] = a0;
                maxDp[1] = minDp[1] = a1;
                maxDp[2] = minDp[2] = a2;
            } else {
                int maxDp0 = Math.max(maxDp[0], maxDp[1]) + a0;
                int maxDp1 = Math.max(Math.max(maxDp[0], maxDp[1]), maxDp[2]) + a1;
                int maxDp2 = Math.max(maxDp[1], maxDp[2]) + a2;

                int minDp0 = Math.min(minDp[0], minDp[1]) + a0;
                int minDp1 = Math.min(Math.min(minDp[0], minDp[1]), minDp[2]) + a1;
                int minDp2 = Math.min(minDp[1], minDp[2]) + a2;

                maxDp[0] = maxDp0;
                maxDp[1] = maxDp1;
                maxDp[2] = maxDp2;

                minDp[0] = minDp0;
                minDp[1] = minDp1;
                minDp[2] = minDp2;
            }
        }
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < 3; i++) {
            max = Math.max(maxDp[i], max);
            min = Math.min(minDp[i], min);
        }
        System.out.println(max + " " + min);
    }


}

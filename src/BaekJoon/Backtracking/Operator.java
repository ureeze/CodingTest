package BaekJoon.Backtracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Operator {
    static int N;
    static List<Integer> result = new ArrayList<>();
    static int[] value;
    static int[] operator;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        value = new int[N];
        operator = new int[4];

        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            value[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            operator[i] = Integer.parseInt(st.nextToken());
        }

        dfs(value[0], 0);
        System.out.println(Collections.max(result));
        System.out.println(Collections.min(result));
    }

    private static void dfs(int preValue, int depth) {
        if (depth == N - 1) {
            result.add(preValue);
            return;
        }
        for (int i = 0; i < 4; i++) {
            if (operator[i] != 0) {
                operator[i]--;
                int nextValue = 0;
                switch (i) {
                    case 0:
                        nextValue = preValue + value[depth + 1];
                        break;
                    case 1:
                        nextValue = preValue - value[depth + 1];
                        break;
                    case 2:
                        nextValue = preValue * value[depth + 1];
                        break;
                    case 3:
                        nextValue = preValue / value[depth + 1];
                        break;
                }
                dfs(nextValue, depth + 1);
                operator[i]++;
            }
        }
    }
}
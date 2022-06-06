package BaekJoon.ETC;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class NumsSum2018 {
    static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());

        int[] arr = new int[N + 1];
        for (int i = 0; i < N + 1; i++) {
            arr[i] = i;
        }
        int left = 1, right = 1;
        int sum = 1, cnt = 1;
        while (right != N) {
            if (sum == N) {
                right++;
                sum += arr[right];
                cnt++;
            } else if (sum < N) {
                right++;
                sum += arr[right];
            } else if (sum > N) {
                sum -= arr[left];
                left++;
            }
        }
        System.out.println(cnt);
    }
}

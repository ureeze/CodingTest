package Programmers.SOCAR2022;

import java.util.*;
import java.util.stream.Collectors;

public class TEST2 {
    static boolean[] visited;
    static int answer;

    public int solution(int[] numbers, int K) {
        answer = Integer.MAX_VALUE;
        visited = new boolean[numbers.length];

        for (int i = 0; i < numbers.length; i++) {
            visited[i] = true;
            int[] arr = new int[numbers.length];
            arr[0] = numbers[i];
            dfs(arr, 1, numbers, K);
            visited[i] = false;
        }

        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int[] arr, int size, int[] numbers, int K) {
        if (size == numbers.length) {
            int count = checkSwap(arr, numbers);
            answer = Math.min(count, answer);
            return;
        }
        for (int i = 0; i < numbers.length; i++) {
            if (!visited[i]) {
                if (checkNums(arr[size - 1], numbers[i], K)) {
                    visited[i] = true;
                    arr[size] = numbers[i];
                    dfs(arr, size + 1, numbers, K);
                    visited[i] = false;
                }
            }
        }
    }

    private int checkSwap(int[] arr, int[] numbers) {
        List<Integer> numList = Arrays.stream(numbers).boxed().collect(Collectors.toList());
        int count = 0;
        int temp;
        for (int i = 0; i < numList.size(); i++) {
            if (arr[i] != numList.get(i)) {
                int index = numList.indexOf(arr[i]);
                temp = numList.get(i);
                numList.set(i, numList.get(index));
                numList.set(index, temp);
                count++;
            }
        }
        return count;
    }

    private boolean checkNums(int number1, int number2, int K) {
        int result = Math.abs(number1 - number2);
        if (result <= K) {
            return true;
        } else {
            return false;
        }
    }


    public static void main(String[] args) {
        TEST2 test2 = new TEST2();
        System.out.println(test2.solution(new int[]{10, 40, 30, 20}, 20));
        System.out.println(test2.solution(new int[]{3, 7, 2, 8, 6, 4, 5, 1}, 3));
    }
}

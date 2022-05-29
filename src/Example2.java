import java.util.*;

public class Example2 {
    public static void main(String[] args) {
        int[][] arr = {{0, 9, 0, 0, 0}, {0, 0, 3, 0, 7}, {0, 8, 4, 0, 0}, {0, 0, 0, 0, 0}, {1, 1, 0, 1, 1}};

        show(arr);
        System.out.println("=====================");
        check(arr);

        show(arr);

    }

    private static void check(int[][] arr) {
        // 2차원 배열 마지막 줄 바로 위의 행(arr.length - 2)부터 0행 까지 검사
        for (int i = arr.length - 2; i >= 0; i--) {
            // 2차원 배열 0열 ~ 마지막 열(arr[i].length-1)까지 검사
            for (int j = 0; j < arr[i].length; j++) {
                // 조회 배열 값이 0이 아니고 바로 아래 배열 값이 0일 때 값 옮길 수 있다.
                if (arr[i][j] != 0 && arr[i + 1][j] == 0) {
                    // i, j 값 변경 방지를 위한 x, y 변수 생성
                    int x = i, y = j;
                    // 행 값이 마지막 행이 아니고(마지막 행일 경우 아래 배열 조회 시 인덱스 오류 발생)
                    // 아래 배열 값이 0일 경우 계속해서 값 옮김
                    while (x != arr.length - 1 && arr[x + 1][y] == 0) {
                        arr[x + 1][y] = arr[x][y];
                        arr[x][y] = 0;
                        x++;
                    }
                }
            }
        }
    }

    private static void show(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println(Arrays.toString(arr[i]));
        }
    }
}
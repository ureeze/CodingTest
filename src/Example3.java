import java.util.Arrays;

public class Example3 {
    public static void main(String[] args) {
        int[][] arr1 = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}};
        int[][] arr2 = arr1.clone();
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2));
        arr1[0][0] = 9;
        System.out.println(Arrays.deepToString(arr1));
        System.out.println(Arrays.deepToString(arr2));


int[][] a = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
int[][] b = new int[a.length][a[0].length];

for (int i = 0; i < a.length; i++) {
    for (int j = 0; j < a[i].length; j++) {
        b[i][j] = a[i][j];
    }
}
    }
}

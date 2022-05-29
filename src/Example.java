import java.util.Arrays;

public class Example {

    public static void main(String[] args) {
        int[] arr = {5, 2, 3, 4, 1};
        int n = arr.length;
//        for (int i = 0; i < n - 1; i++) {
//            for (int j = 0; j < n - 1 - i; j++) {
//                if (arr[j] > arr[j + 1]) {
//                    int temp = arr[j + 1];
//                    arr[j + 1] = arr[j];
//                    arr[j] = temp;
//                }
//            }
//        }
//        for (int i = 0; i < n - 1; i++) {
//            int min = i;
//            for (int j = i; j < n; j++) {
//                if (arr[min] > arr[j]) {
//                    min = j;
//                }
//            }
//            int temp = arr[i];
//            arr[i] = arr[min];
//            arr[min] = temp;
//        }
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j;
            for (j = i - 1; j >= 0 && key < arr[j]; j--) {
                arr[j + 1] = arr[j];
            }
            arr[j + 1] = key;
        }
        System.out.println(Arrays.toString(arr));
    }
}
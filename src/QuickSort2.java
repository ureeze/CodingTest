import java.util.Arrays;

public class QuickSort2 {
    private static void quickSort(int[] arr, int start, int end) {
        // 배열의 크기가 1이하이면 정렬 할 필요 없다.
        if (start >= end) {
            return;
        }
        // 분할
        int pivot = partition(arr, start, end);

        // 왼쪽 배열 퀵정렬
        quickSort(arr, start, pivot - 1);

        // 오른쪽 배열 퀵정렬
        quickSort(arr, pivot + 1, end);
    }

    private static int partition(int[] arr, int start, int end) {
        // 배열의 맨 왼쪽 값을 pivot 값으로 지정
        int pivot = arr[start];
        int left = start + 1;
        int right = end;
        while (left <= right) {
            while (arr[left] < pivot) {
                left++;
            }
            while (pivot < arr[right]) {
                right--;
            }
            if (left <= right) {
                swap(arr, left, right);
                left++;
                right++;
            }
        }
        swap(arr, start, right);
        return right;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return;
    }

    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 8, 3, 5, 1, 6, 0, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
import java.util.Arrays;

public class QuickSort {
    private static void quickSort(int[] arr, int start, int end) {
        int part = partition(arr, start, end);
        if (start < part - 1) {
            quickSort(arr, start, part - 1);
        }
        if (part < end) {
            quickSort(arr, part, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2];
        while (start <= end) {
            while (arr[start] < pivot) {
                start++;
            }
            while (pivot < arr[end]) {
                end--;
            }
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
        return;
    }


    public static void main(String[] args) {
        int[] arr = {7, 4, 2, 8, 3, 5, 1, 6, 10, 9};
        quickSort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
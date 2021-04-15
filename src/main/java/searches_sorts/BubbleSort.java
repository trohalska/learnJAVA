package searches_sorts;

import java.util.Arrays;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 22, -5, 0, 6};
        sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (arr[i] > arr[j]) {
                    int tmp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = tmp;
                }
            }
        }
    }
}

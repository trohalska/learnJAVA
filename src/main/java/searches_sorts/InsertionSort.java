package searches_sorts;

import java.util.Arrays;
/**
 * проходить послідовно
 * бере елемент і переміщує на необхідну позицію у відсортованій частині
 */
public class InsertionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 22, -5, 0, 6};
        sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 1; i < len; i++) {
            int j = i;
            while (j > 0 && arr[j] < arr[j - 1]) {
                int tmp = arr[j - 1];
                arr[j - 1] = arr[j];
                arr[j] = tmp;
                j--;
            }
        }
    }
}

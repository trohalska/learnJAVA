package searches_sorts;

import java.util.Arrays;
/**
 * проходить послідовно
 * вибирає мінімальний елемент в невідсортованій частині і свапає
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 22, -5, 0, 6};
        sort(arr);

        Arrays.stream(arr).forEach(System.out::println);
    }

    public static void sort(int[] arr) {
        int len = arr.length;

        for (int i = 0; i < len - 1; i++) {
            int min = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[min];
            arr[min] = tmp;
        }
    }
}

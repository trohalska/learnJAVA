import java.util.Arrays;

public class Main_tech {
    public static void main(String[] args) {
        int[] arr = {7, 3, 4, 7, 4, 1, 0, 9};
        sort(arr);
    }

    public static void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("before: " + Arrays.toString(arr));
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            while (j - 1 >= 0 && arr[j] > arr[j - 1]) {
                int tmp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = tmp;
                j--;
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }
}

package searches_sorts;

/* Given a sorted array arr[] of n elements, write a function to search a given element ‘23’ in arr[], and return its index.
Search a sorted array by repeatedly dividing the search interval in half. Begin with an interval covering the whole array.
If the value of the search key is less than the item in the middle of the interval, narrow the interval to the lower half.
Otherwise, narrow it to the upper half. Repeatedly check until the value is found or the interval is empty. */

public class Binary {
    public static void main(String[] args) {
        int[] arr2 = { 2, 5, 8, 12, 16, 23, 38, 56, 72, 91 };
        System.out.println(search(arr2, -1)); // -1
        System.out.println(search(arr2, 2)); // 0
        System.out.println(search(arr2, 3)); // -1
        System.out.println(search(arr2, 5)); // 1
        System.out.println(search(arr2, 10)); // -1
        System.out.println(search(arr2, 16)); // 4
        System.out.println(search(arr2, 23)); // 5
        System.out.println(search(arr2, 38)); // 6
        System.out.println(search(arr2, 90)); // -1
        System.out.println(search(arr2, 91)); // 9
        System.out.println(search(arr2, 100)); // -1
        System.out.println(search(new int[]{2}, 2)); // 0
        System.out.println(search(new int[]{2}, 22)); // -1
    }

    public static int search(int arr[], int value) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int middle = left + (right - left) / 2;

            if (arr[middle] == value) {
                return middle;
            }
            if (arr[middle] < value) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }
}


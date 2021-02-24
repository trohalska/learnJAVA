package patterns;

import java.util.Arrays;

/**
 * очень похож на Stage -> клиент вызывает стратегию, которая ему нужна
 * Сам клиент меняет стратегию поведения и после єтого делает работу
 */
public class StrategyApp {
    public static void main(String[] args) {

        StrategyClient c = new StrategyClient();

        int[] arr0 = {1,3,2,1};
        c.setStrategy(new SelectionSort());
        c.executeStrategy(arr0);

        int[] arr1 = {11,4,2,7,8,54,1};
        c.setStrategy(new InsertionSort());
        c.executeStrategy(arr1);

        int[] arr2 = {3,-8,2,0,33,1,3,2};
        c.setStrategy(new BubbleSort());
        c.executeStrategy(arr2);
    }
}

/**
 * CONTEXT
 */
class StrategyClient {
    Sorting strategy;
    public void setStrategy(Sorting strategy) {
        this.strategy = strategy;
    }
    public void executeStrategy(int[] arr) {
        strategy.sort(arr);
    }
}

/**
 * STRATEGY
 */
interface Sorting {
    void sort(int[] arr);
}
class BubbleSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Bubble sort");
        System.out.println("before: " + Arrays.toString(arr));
        for (int barrier = arr.length - 1; barrier >= 0; barrier--) {
            for (int i = 0; i < barrier; i++) {
                if (arr[i] > arr[i + 1]) {
                    int tmp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = tmp;
                }
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }
}
class SelectionSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Selection sort");
        System.out.println("before: " + Arrays.toString(arr));
        for (int barrier = 0; barrier < arr.length - 1; barrier++) {
            for (int i = barrier + 1; i < arr.length; i++) {
                if (arr[i] < arr[barrier]) {
                    int tmp = arr[i];
                    arr[i] = arr[barrier];
                    arr[barrier] = tmp;
                }
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }
}
class InsertionSort implements Sorting {
    public void sort(int[] arr) {
        System.out.println("Insertion sort");
        System.out.println("before: " + Arrays.toString(arr));
        for (int barrier = 1; barrier < arr.length; barrier++) {
            int index = barrier;
            while (index - 1 >= 0 && arr[index] < arr[index - 1]) {
                int tmp = arr[index];
                arr[index] = arr[index - 1];
                arr[index - 1] = tmp;
                index--;
            }
        }
        System.out.println("after: " + Arrays.toString(arr));
    }
}
import java.util.Arrays;

public class ShellSort {
    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }


    public static void sort(int[] arr) {
        for (int k = arr.length / 2; k > 1; k /= 2) {
            for (int i = 0; i < k; i++) {
                incrementalInsertion(arr, i, k);
            }
        }
    }

    private static void incrementalInsertion(int[] collection, int start, int increment) {

        for (int i = start + increment; i < collection.length; i += increment) {
            for (int j = i; j > increment; j -= increment) {
                if (collection[j] < collection[j - increment]) {
                    swap(collection, j, j - increment);
                }
            }
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

}

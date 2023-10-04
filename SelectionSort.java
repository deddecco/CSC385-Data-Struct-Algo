import java.util.Arrays;

public class SelectionSort {

    public static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int indexOfSmallest = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[indexOfSmallest]) {
                    indexOfSmallest = j;
                }
            }
            swap(arr, indexOfSmallest, i);
        }
    }

    private static void swap(int[] arr, int a, int b) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }
}

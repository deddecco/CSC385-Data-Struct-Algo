import java.util.Arrays;

public class InsertionSort {
    public static void main(String[] args) {

        int[] arr = {64, 25, 12, 22, 11};
        System.out.println(Arrays.toString(arr));
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int j = 2; j < arr.length; j++) {
            int key = arr[j];
            int i = j - 1;

            while (arr[i] > key && i > 0) {
                arr[i + 1] = arr[i];
                i--;
                arr[i + 1] = key;
            }
        }
    }

}



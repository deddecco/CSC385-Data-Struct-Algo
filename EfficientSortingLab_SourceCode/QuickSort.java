package EfficientSortingLab_SourceCode;

public class QuickSort {

    public static void sort(Object[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    public static void sort(Object[] arr, int lo, int hi) {
        if (lo < hi) {
            int partitionIndex = partition(arr, lo, hi);
            sort(arr, lo, partitionIndex - 1);
            sort(arr, partitionIndex + 1, hi);
        }
    }


    public static int partition(Object[] arr, int lo, int hi) {
        Object pivot = arr[hi];
        int i = (lo - 1);

        for (int j = lo; j < hi; j++) {
            int res = ((Comparable) arr[j]).compareTo(pivot);
            if (res <= 0) {
                i++;
                swap(arr, i, j);
            }
        }

        swap(arr, i + 1, hi);

        return i + 1;
    }

    private static void insertionSort(Object[] arr, int first, int last) {
        for (int i = first; i < last; i++) {
            for (int j = i + 1; j > first; j--) {
                int res = ((Comparable) arr[j]).compareTo(arr[j - 1]);
                if (res < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
        }
    }

    private static void sortFirstMiddleLast(Object[] arr, int first, int mid, int last) {
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
        if (((Comparable) arr[mid]).compareTo(arr[last]) > 0) {
            swap(arr, mid, last);
        }
        if (((Comparable) arr[first]).compareTo(arr[mid]) > 0) {
            swap(arr, first, mid);
        }
    }

    private static void swap(Object[] arr, int idx1, int idx2) {
        Object temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }


}

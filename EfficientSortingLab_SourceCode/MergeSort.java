package EfficientSortingLab_SourceCode;

import static java.lang.System.arraycopy;

public class MergeSort {
    public static void sort(Object[] arr) {

        // base case
        if (arr.length < 2) {
            return;
        }

        int middle = arr.length / 2;

        // create the left and right halves
        Object[] leftSide = new Object[middle];
        Object[] rightSide = new Object[arr.length - middle];

        // populate the left and right halves
        arraycopy(arr, 0, leftSide, 0, middle);

        if (arr.length - middle >= 0) {
            arraycopy(arr, middle, rightSide, 0, arr.length - middle);
        }

        // sort the left and right halves recursively
        sort(leftSide);
        sort(rightSide);

        // merge what you sorted-- this is where the sorting actually happens
        merge(arr, leftSide, rightSide);
    }


    private static void merge(Object[] array, Object[] left, Object[] right) {

        // 3 pointers-- one for the left half, one for the right half, one for the merged array
        int i = 0;
        int j = 0;
        int k = 0;

        // while still have elements in both
        while (i < left.length && j < right.length) {
            // if element in left less, put it in merged array
            // move left index

            int res = ((Comparable) left[i]).compareTo(right[j]);
            if (res < 0) {
                array[k] = left[i];
                i++;
            }
            // if element in right less, put it in merged array
            // move right index
            else {
                array[k] = right[j];
                j++;
            }

            // move merged index
            k++;
        }

        // if still unmerged elements in left, copy them into merged
        while (i < left.length) {
            array[k] = left[i];
            i++;
            k++;
        }

        // if still unmerged elements in right, copy them into right
        while (j < right.length) {
            array[k] = right[j];
            j++;
            k++;
        }

    }

}
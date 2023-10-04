import static java.lang.Math.min;
import static java.lang.System.arraycopy;

public class IntegerSet {

    // The array that represents the set.
    private final int[] set;

    public int[] getSet() {
        return set;
    }

    /**
     * The constructor for IntegerSet. When an IntegerSet is created it must be
     * initialized with an integer array. The set will then pull out the duplicated
     * items and keep the unique integers.
     *
     * @param arr The array to create the set from.
     */
    public IntegerSet(int[] arr) {
        if (arr == null) {
            throw new IllegalArgumentException("The array must not be null");
        }
        set = uniqueElements(arr);
    }

    /**
     * This is the size of the set which, in this case, is just the length of the
     * array.
     *
     * @return The length of the set.
     */
    public int magnitude() {
        return set.length;
    }

    /**
     * This method is private and is used to help set up the set array. An integer
     * set is one in which the elements are unique (no duplicates) and are sorted.
     *
     * @param arr The array that will be used to retrieve the unique elements from.
     * @return The new integer array that contains the unique elements from arr.
     */

    private int[] uniqueElements(int[] arr) {
        // sort
        mergeSort(arr);

        // at its biggest, the array of unique elements is the same size as the original, if all elements in the original are unique
        int[] uniqueElements = new int[arr.length];
        // the index in the new array
        int idx = 0;
        // looking through the original input
        for (int i = 0; i < arr.length; i++) {
            // move forward over runs of duplicates
            while ((i < (arr.length - 1)) && (arr[i] == arr[i + 1])) {
                i++;
            }
            // place the last occurrence in a chain of duplicates in uniqueElements
            // this will be the first time after a run such that arr[i] won't be equal to arr[i + 1]
            uniqueElements[idx] = arr[i];
            // move idx-- go to the next position in the array of unique elements
            idx++;
        }

        // truncate
        // since the original was sorted as per the first instruction in this method, this will also be sorted
        return IntArrayOperations.truncateArray(uniqueElements, idx);
    }

    /**
     * This method returns whether value is located in the set. If the value
     * is in the set then return true otherwise return false. <br />
     * Example:
     * <pre>
     * 		IntegerSet iS1 = new IntegerSet([1,2,3,4]);
     * 		iS1.contains(3); //returns true
     * 		iS2.contains(6); //returns false
     * </pre>
     *
     * @param value The integer to look for.
     * @return True if value is located in the set otherwise false.
     */

    public boolean contains(int value) {
        // an empty set does not contain anything so this should be false
        if (set == null || magnitude() == 0) {
            return false;
        }

        // if the set is not empty, look for the element, get back an index, and return whether that index is -1
        // if the index is -1, the set does not contain the element
        // if the index is anything else, the set does contain the element
        return binarySearch(value, set, magnitude() - 1, 0) != -1;
    }


    public static int binarySearch(int value, int[] set, int high, int low) {
        // binary search requires the elements be sorted
        mergeSort(set);
        // initial index is index to be returned if not found
        int index = -1;

        // while the pointers haven't met or crossed
        while (low <= high) {
            // calculate mid this way to mitigate overflow risk
            int mid = low + ((high - low) / 2);
            // if set[mid] is less than the value, ignore everything to its left
            if (set[mid] < value) {
                low = mid + 1;
            }
            // if set[mid] is greater than the value, ignore everything to its right
            else if (set[mid] > value) {
                high = mid - 1;
            } // if you've found the element, stop
            else if (set[mid] == value) {
                index = mid;
                break;
            }
        }
        return index;

    }


    /**
     * A union of two sets is a new set that contains all elements from both sets.
     * This method takes another set and unions it with the set that calls this
     * method. A new IntegerSet is returned that contains the union of both sets.<br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1, 2, 3, 4]);
     * 		IntegerSet is2 = new IntegerSet([3, 4, 5, 6, 7, 8]);
     * 		is1.union(is2) //returns new IntegerSet([1, 2, 3, 4, 5, 6, 7, 8]);
     * </pre>
     *
     * @param otherSet The set to be unioned with.
     * @return A new IntegerSet that is the union of the calling set with the
     * otherSet.
     */
    public IntegerSet union(IntegerSet otherSet) {

        // the union of 2 empty sets is empty
        if (magnitude() == 0 && otherSet.set.length == 0) {
            int[] emptySet = new int[0];
            return new IntegerSet(emptySet);
        }

        // the union of a non-empty set and an empty set is the non-empty set
        if (magnitude() == 0) {
            return otherSet;
        }

        if (otherSet.set.length == 0) {
            return new IntegerSet(set);
        }


        // the union of two sets is at most as big as the sum of the sizes of the two sets
        // create an array that big
        int[] union = new int[magnitude() + otherSet.set.length];

        // copy in the two sets
        arraycopy(set, 0, union, 0, magnitude());
        arraycopy(otherSet.set, 0, union, magnitude(), otherSet.set.length);


        // adjust the union by checking for and removing duplicates and placing the new set in a new array
        int[] adjustedUnion = uniqueElements(union);

        // now we have all the unique elements in set 1 and all the unique elements in set 2 in a single array
        return new IntegerSet(adjustedUnion);
    }

    /**
     * The intersection of two sets is a new set that contains elements that occur
     * in both sets. This method takes another set and intersects it with the set
     * that calls this method. A new IntegerSet is returned that contains the
     * intersection of the two sets. <br />
     * Example:
     * <pre>
     * 		IntegerSet is1 = new IntegerSet([1,2,3,4]);
     * 		IntegerSet is2 = new IntegerSet([3,4,5]);
     * 		is1.intersection(is2) //returns new IntegerSet([3, 4]);
     * </pre>
     *
     * @param otherSet The set to be intersected with.
     * @return A new IntegerSet that is the intersection of the calling set with the
     * otherSet.
     */
    public IntegerSet intersection(IntegerSet otherSet) {

        // if either set is empty, the intersection of an empty set and a non-empty set is the empty set
        if (magnitude() == 0 || otherSet.set.length == 0) {
            int[] emptySet = new int[0];
            return new IntegerSet(emptySet);
        }


        // the size of the intersection can only be as big as the size of the smaller set
        int intersectionMaxSize = min(otherSet.set.length, magnitude());
        // keeps track of how many elements have actually been put in the intersection set
        int intersectionActualSize = 0;
        // array to store the intersection, maybe has extra spaces, will truncate later
        int[] intersectionPrelim = new int[intersectionMaxSize];


        // index in new array
        int j = 0;
        for (int i = 0; i < intersectionMaxSize; i++) {
            // if set[i] is found anywhere in otherSet
            if (binarySearch(set[i], otherSet.set, otherSet.set.length - 1, 0) != -1) {
                // put it at position j in intersectionPrelim
                intersectionPrelim[j] = set[i];
                // move j by 1
                j++;
                // increment the size of the intersection
                intersectionActualSize++;
                // because they move together, the counter of the sizew of the intersection and the index in intersectionPrelim should always be equal
            }
        }

        // truncate the array to only be as big as intersectionActualSize
        int[] intersection = IntArrayOperations.truncateArray(intersectionPrelim, intersectionActualSize);


        // return the IntegerSet that contains intersection
        return new IntegerSet(intersection);
    }

    /**
     * Returns a string representation of an IntegerSet type. The returned string
     * will have the following structure.
     * <p>
     * set{ elements in the set separated by a comma }.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("set{ ");
        for (int i = 0; i < magnitude(); i++) {
            sb.append(set[i]);
            if (i < magnitude() - 1) {
                sb.append(", ");
            }
        }
        sb.append(" }");
        return sb.toString();
    }

    private static void mergeSort(int[] array) {

        // base case
        if (array.length < 2) {
            return;
        }

        int middle = array.length / 2;


        // create the left and right halves
        int[] leftSide = new int[middle];
        int[] rightSide = new int[array.length - middle];

        // populate the left and right halves
        arraycopy(array, 0, leftSide, 0, middle);

        if (array.length - middle >= 0) {
            arraycopy(array, middle, rightSide, 0, array.length - middle);
        }

        // sort the left and right halves recursively
        mergeSort(leftSide);
        mergeSort(rightSide);


        // merge what you sorted
        merge(array, leftSide, rightSide);
    }

    private static void merge(int[] array, int[] left, int[] right) {

        // 3 pointers-- one for the left half, one for the right half, one for the merged array
        int i = 0;
        int j = 0;
        int k = 0;

        // while still have elements in both
        while (i < left.length && j < right.length) {
            // if element in left less, put it in merged array
            // move left index
            if (left[i] <= right[j]) {
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
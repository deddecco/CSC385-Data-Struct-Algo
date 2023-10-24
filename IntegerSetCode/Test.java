package IntegerSetCode;

import java.util.Arrays;

public class Test {
	private static void testIntegerSetConstructorNonEmpty() {
		int[] arr = { 6, 6, 2, 8, 8, 7, 1, 1, 4, 3, 3, 3 };
		IntegerSet iS1 = new IntegerSet(arr);
		int[] set = iS1.getSet();
		int[] expected = { 1, 2, 3, 4, 6, 7, 8 };
		if (Arrays.equals(set, expected)) {
			System.out.println("[O] Passed Constructor IntegerSetCode.Test NonEmpty");
		} else {
			System.out.println("[X] Failed Constructor IntegerSetCode.Test NonEmpty");
			System.out.println("\tArray input: " + Arrays.toString(arr));
			System.out.println("\tiS1: " + iS1);
			System.out.println("\tExpected: " + Arrays.toString(expected));
			System.out.println("\tActual: " + Arrays.toString(set));
		}
	}

	private static void testIntegerSetConstructorEmpty() {
		int[] arr = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr);
			int[] set = iS1.getSet();
			int[] expected = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Constructor IntegerSetCode.Test Empty");
			} else {
				System.out.println("[X] Failed Constructor IntegerSetCode.Test Empty");
				System.out.println("\tArray input: " + Arrays.toString(arr));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Constructor IntegerSetCode.Test Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testContainsNonEmptyTrue() {
		int[] arr = { 9, 10, 14, 16, 18, 22, 26, 32, 38, 46, -49, -40, -36, -32, -28, -25, -21, -18, -5 };
		IntegerSet iS1 = new IntegerSet(arr);
		int value = -36;
		boolean result = iS1.contains(value);
		if (result) {
			System.out.println("[O] Passed Contains IntegerSetCode.Test Non Empty True");
		} else {
			System.out.println("[X] Failed Contains IntegerSetCode.Test Non Empty True");
			System.out.println("\tArray input: " + Arrays.toString(arr));
			System.out.println("\tiS1: " + iS1);
			System.out.println("\tContains: " + value);
			System.out.println("\tExpected: True");
			System.out.println("\tActual: " + result);
		}
	}

	private static void testContainsNonEmptyFalse() {
		int[] arr = { 9, 10, 14, 16, 18, 22, 26, 32, 38, 46, -49, -40, -36, -32, -28, -25, -21, -18, -5 };
		IntegerSet iS1 = new IntegerSet(arr);
		int value = -100;
		boolean result = iS1.contains(value);
		if (!result) {
			System.out.println("[O] Passed Contains IntegerSetCode.Test Non Empty False");
		} else {
			System.out.println("[X] Failed Contains IntegerSetCode.Test Non Empty False");
			System.out.println("\tArray input: " + Arrays.toString(arr));
			System.out.println("\tiS1: " + iS1);
			System.out.println("\tContains: " + value);
			System.out.println("\tExpected: False");
			System.out.println("\tActual: " + result);
		}
	}

	private static void testContainsEmptyFalse() {
		int[] arr = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr);
			int value = -100;
			boolean result = iS1.contains(value);
			if (!result) {
				System.out.println("[O] Passed Contains IntegerSetCode.Test Empty False");
			} else {
				System.out.println("[X] Failed Contains IntegerSetCode.Test Empty False");
				System.out.println("\tArray input: " + Arrays.toString(arr));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tContains: " + value);
				System.out.println("\tExpected: False");
				System.out.println("\tActual: " + result);
			}
		} catch (Exception e) {
			System.out.println("[X] Contains empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testUnionNonEmpty() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int[] arr2 = { 6, 2, 8, 7, 1, 1, 4, 3 };
		IntegerSet iS1 = new IntegerSet(arr1);
		IntegerSet iS2 = new IntegerSet(arr2);
		IntegerSet result = iS1.union(iS2);
		int[] set = result.getSet();
		int[] expected = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
		if (Arrays.equals(set, expected)) {
			System.out.println("[O] Passed Union NonEmpty");
		} else {
			System.out.println("[X] Failed Union NonEmpty");
			System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
			System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
			System.out.println("\tiS1: " + iS1);
			System.out.println("\tiS2: " + iS2);
			System.out.println("\tExpected: " + Arrays.toString(expected));
			System.out.println("\tActual: " + Arrays.toString(set));
		}
	}

	private static void testUnionIS1Empty() {
		int[] arr1 = {};
		int[] arr2 = { 6, 2, 8, 7, 1, 1, 4, 3 };
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.union(iS2);
			int[] set = result.getSet();
			int[] expected = { 1, 2, 3, 4, 6, 7, 8 };
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Union iS1 Empty");
			} else {
				System.out.println("[X] Failed Union iS1 Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Union iS1 Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testUnionIS2Empty() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int[] arr2 = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.union(iS2);
			int[] set = result.getSet();
			int[] expected = { 1, 2, 5, 6, 7, 9 };
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Union iS2 Empty");
			} else {
				System.out.println("[X] Failed Union iS2 Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Union iS2 Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testUnionBothEmpty() {
		int[] arr1 = {};
		int[] arr2 = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.union(iS2);
			int[] set = result.getSet();
			int expected[] = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Union Both Empty");
			} else {
				System.out.println("[X] Failed Union Both Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Union Both Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionNonEmpty() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int arr2[] = { 6, 2, 8, 7, 1, 1, 4, 3 };
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int[] expected = { 1, 2, 6, 7 };
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection NonEmpty");
			} else {
				System.out.println("[X] Failed Intersection NonEmpty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] IntegerSetCode.Test Intersection: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionIS1Empty() {
		int[] arr1 = {};
		int[] arr2 = { 6, 2, 8, 7, 1, 1, 4, 3 };
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int expected[] = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection iS1 Empty");
			} else {
				System.out.println("[X] Failed Intersection iS1 Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Intersection iS1 Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionIS2Empty() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int[] arr2 = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int expected[] = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection iS2 Empty");
			} else {
				System.out.println("[X] Failed Intersection iS2 Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Intersection iS2 Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionBothEmpty() {
		int[] arr1 = {};
		int[] arr2 = {};
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int expected[] = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection Both Empty");
			} else {
				System.out.println("[X] Failed Intersection Both Empty");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Intersection Both Empty: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionNonEmptyNoIntersections() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int[] arr2 = { 10 };
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int expected[] = {};
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection NonEmpty no intersections");
			} else {
				System.out.println("[X] Failed Intersection NonEmpty no intersections");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Intersection NonEmpty no intersections: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	private static void testIntersectionPerfectIntersections() {
		int[] arr1 = { 5, 1, 6, 7, 2, 9 };
		int[] arr2 = { 1, 7, 6, 5, 9, 2 };
		try {
			IntegerSet iS1 = new IntegerSet(arr1);
			IntegerSet iS2 = new IntegerSet(arr2);
			IntegerSet result = iS1.intersection(iS2);
			int[] set = result.getSet();
			int[] expected = { 1, 2, 5, 6, 7, 9 };
			if (Arrays.equals(set, expected)) {
				System.out.println("[O] Passed Intersection NonEmpty perfect intersections");
			} else {
				System.out.println("[X] Failed Intersection NonEmpty perfect intersections");
				System.out.println("\tArray iS1 input: " + Arrays.toString(arr1));
				System.out.println("\tArray iS2 input: " + Arrays.toString(arr2));
				System.out.println("\tiS1: " + iS1);
				System.out.println("\tiS2: " + iS2);
				System.out.println("\tExpected: " + Arrays.toString(expected));
				System.out.println("\tActual: " + Arrays.toString(set));
			}
		} catch (Exception e) {
			System.out.println("[X] Intersection NonEmpty perfect intersections: " + e.getClass().getName());
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		testIntegerSetConstructorNonEmpty();
		testIntegerSetConstructorEmpty();
		testContainsNonEmptyTrue();
		testContainsNonEmptyFalse();
		testContainsEmptyFalse();
		testUnionNonEmpty();
		testUnionIS1Empty();
		testUnionIS2Empty();
		testUnionBothEmpty();
		testIntersectionNonEmpty();
		testIntersectionIS1Empty();
		testIntersectionIS2Empty();
		testIntersectionBothEmpty();
		testIntersectionNonEmptyNoIntersections();
		testIntersectionPerfectIntersections();
	}
}

package EfficientSortingLab_SourceCode;

import static EfficientSortingLab_SourceCode.MergeSort.*;
import static java.lang.Math.*;

public class MergeSortTest {
	private static void randomIntArray(Integer[] arr, int min, int max) {
		int mn = min(min, max);
		int mx = max(min, max) + 1;
		for(int i = 0; i < arr.length; i++) {
			int value = (int)(random() * (mx - mn)) + mn;
			arr[i] = value;
		}
	}
	
	private static void randomStringArray(String[] arr, int min, int max) {
		if(min < 0) {
			throw new IllegalArgumentException("Min for randomStringArray must be >= 0");
		}
		int mn = min(min, max);
		int mx = max(min, max) + 1;
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			StringBuilder s = new StringBuilder();
			int rLen = (int)(random() * (mx - mn)) + mn;
			for(int j = 0; j < rLen; j++) {
				int rCharIdx = (int)(random() * alphabet.length);
				s.append(alphabet[rCharIdx]);
			}
			arr[i] = s.toString();
		}
	}
	
	private static boolean isSorted(Object[] arr) {
		for(int i = 0; i < arr.length - 1; i++) {
			if(((Comparable) arr[i]).compareTo(arr[i+1]) > 0) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		Integer[] iArr = new Integer[1000];
		randomIntArray(iArr, 0, 100);
		sort(iArr);
		System.out.println("MERGE SORT INTEGER ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
		
		String[] sArr = new String[1000];
		randomStringArray(sArr, 10, 20);
		sort(sArr);
		System.out.println("MERGE SORT STRING ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
	}
}

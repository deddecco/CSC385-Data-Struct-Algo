package EfficientSortingLab_SourceCode;

public class QuickSortTest {
	private static void randomIntArray(Integer[] arr, int min, int max) {
		int mn = Math.min(min, max);
		int mx = Math.max(min, max) + 1;
		for(int i = 0; i < arr.length; i++) {
			int value = (int)(Math.random() * (mx - mn)) + mn;
			arr[i] = value;
		}
	}
	
	private static void randomStringArray(String[] arr, int min, int max) {
		if(min < 0) {
			throw new IllegalArgumentException("Min for randomStringArray must be >= 0");
		}
		int mn = Math.min(min, max);
		int mx = Math.max(min, max) + 1;
		
		char[] alphabet = "abcdefghijklmnopqrstuvwxyz".toCharArray();
		
		for(int i = 0; i < arr.length; i++) {
			StringBuilder s = new StringBuilder();
			int rLen = (int)(Math.random() * (mx - mn)) + mn;
			for(int j = 0; j < rLen; j++) {
				int rCharIdx = (int)(Math.random() * alphabet.length);
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
		randomIntArray(iArr, -100, 100);
		QuickSort.sort(iArr);
		System.out.println("QUICK SORT INTEGER ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
		
		String[] sArr = new String[1000];
		randomStringArray(sArr, 10, 20);
		QuickSort.sort(sArr);
		System.out.println("QUICK SORT STRING ARRAY IS SORTED? " + (isSorted(iArr) ? "YES" : "NO"));
	}
}

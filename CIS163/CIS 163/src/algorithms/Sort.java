package algorithms;

public class Sort {
	
	private static <T extends Comparable<T>> void swap(T[] arr, int first, int second) {
		T temp = arr[first];
		arr[first] = arr[second];
		arr[second] = temp;
	}
		
	public static <T extends Comparable<T>> String printVals(T[] arr) {
		String repr = "[ ";
		for (T t : arr) {
			repr += t + ", ";
		}
		repr += " ]";
		return repr;
	}
	
	public static <T extends Comparable<T>> void bubble(T[] arr) {
		int position;
		int scan;
		T temp;
		
		for (position = arr.length - 1; position >= 0; position--) {
			for (scan = 0; scan <= position - 1; scan++){
				if (arr[scan].compareTo(arr[scan+1]) > 0) {
					swap(arr, scan, scan + 1);
				}
			}
		}
	}
	
	public static <T extends Comparable<T>> void select(T[] arr) {
		int currentMin;
		T temp;
		
		for (int index = 0; index < arr.length - 1; index++) {
			currentMin = index;
			for (int scan = index + 1; scan<arr.length; scan++) {
				if (arr[scan].compareTo(arr[currentMin]) < 0) {
					currentMin = scan;
				}
			}
			swap(arr, currentMin, index);
		}
	}
	
	public static <T extends Comparable<T>> void insert(T[] arr) {
		
		for (int i = 1; i < arr.length; i++) {
			T temp = arr[i];
			int j = i;
			
			while(j > 0 && arr[j-1].compareTo(temp) > 0) {
				arr[j] = arr[j-1];
				j--;
			}
			
			arr[j] = temp;
			
		}
		
	}
	
	public static <T extends Comparable<T>> void quick(T[] arr, int min, int max) {
		
		if (min < max) {
			int index = partition(arr, min, max);
		}
		
		quick(arr, min, index - 1);
		quick(arr, index + 1, max);
		
	}
	
	public static <T extends Comparable<T>> int partition(T[] arr, int min, int max) {
		T partitionElement;
		int left, right;
		int middle = (min + max) / 2;
		
		partitionElement = arr[middle];
		swap(arr, middle, min);
		
		left = min;
		right = max;
		
		while (left < right) {
			while (left < right && arr[left].compareTo(partitionElement) <= 0) {
				right--;
			}
			if (left < right) {
				swap(arr, left, right);
			}
			swap(arr, right, left);
		}
		
		return right;
	}
	
	public static <T extends Comparable<T>> void quick(T[] arr) {
		quick(arr, arr.length - 1, arr.length + 1);
	}
 
}

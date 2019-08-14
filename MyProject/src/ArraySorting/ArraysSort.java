package ArraySorting;

import java.util.Arrays;

public class ArraysSort {
	public static void main(String[] args) {
		int arr[] = { 100, 1, 40, 0, 4 };
		Arrays.sort(arr);
		int temp;
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
		System.out.println("Search an element: ");
		System.out.println(Arrays.binarySearch(arr, 40));
	}

}

package com.shift4good.interview.sort;

public class Sort<T> {

	public static <T extends Comparable<T>> T[] execSort(T[] arr) {
		for (int i = arr.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (arr[i].compareTo(arr[j]) < 0) {
					T temp = arr[j];
					arr[j] = arr[i];
					arr[i] = temp;
				}
			}
		}
		return arr;
	}

}

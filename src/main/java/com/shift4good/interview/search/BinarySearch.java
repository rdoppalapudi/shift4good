package com.shift4good.interview.search;

public class BinarySearch<T extends Comparable<T>> implements Searchable<T> {
	private T data[];

	public BinarySearch(T[] arr) {
		this.data = arr;
	}

	@Override
	public int search(T item) {
		return search(item, 0, data.length - 1);
	}

	public int search(T item, int left, int right) {

		int m = (left + right) / 2;
		if (data[m].equals(item)) {
			return m;
		} else if (data[m].compareTo(item) > 0) {
			return search(item, left, m);
		} else {
			return search(item, m + 1, right);
		}
	}

	public static void main(String args[]) {
		Integer[] arr = { 1, 5, 7, 10, 12, 13, 23, 34, 57, 92, 100, 101, 120, 121 };
		Searchable<Integer> bs = new BinarySearch<Integer>(arr);
		System.out.println("Element: 34 found " + "at index: " + bs.search(new Integer(34)));
		String[] strArr = { "ab", "bc", "cd", "ef", "mq", "top" };
		Searchable<String> bStr = new BinarySearch<String>(strArr);
		System.out.println("Element: ef found " + "at index: " + bStr.search(new String("ef")));

	}

}

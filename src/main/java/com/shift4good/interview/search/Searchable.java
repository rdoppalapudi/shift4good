package com.shift4good.interview.search;

import java.util.Comparator;

public interface Searchable<T extends Comparable<T> > {
	public int search(T ele);
}

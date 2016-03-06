package com.shift4good.interview.search;

public interface Searchable<T extends Comparable<T> > {
	public int search(T ele);
}

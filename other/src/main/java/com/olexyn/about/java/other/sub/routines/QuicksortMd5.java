package com.olexyn.about.java.other.sub.routines;


import java.util.Map;

public class QuicksortMd5 {
	private Map<Integer, Artifacts.MFile> md5Pool;
	private int i;
	private int j;
	private int p;

	public Map<Integer, Artifacts.MFile> quicksortMd5(Map<Integer, Artifacts.MFile> md5Pool) {
		this.md5Pool = md5Pool;

		quicksort(0, md5Pool.size() - 1);
		return this.md5Pool;
	}

	private void quicksort(int low, int high) {
		i = low;
		j = high;
		p = low + (high - low) / 2;

		while (i < j) {

			// a < b a.compareto(b) = -1
			// a = b a.compareto(b) = 0
			// a > b a.compareto(b) = 1

			while (i < p) {
				if (imd5().compareTo(pmd5()) <= 0) {
					i++;
				} else {
					swap(i, p);
					j = high;
				}
			}

			while (p < j) {
				if (jmd5().compareTo(pmd5()) >= 0) {
					j--;
				} else {
					swap(p, j);
					i = low;
				}
			}
		}

		if (high - p > 2) {
			quicksort(p, high);
		}
		if (p - low > 2) {
			quicksort(low, p);
		}
	}

	private void swap(int a, int b) {
		 Artifacts.MFile temp = md5Pool.get(a);
		md5Pool.put(a, md5Pool.get(b));
		md5Pool.put(b, temp);
	}

	private String imd5() {
		return md5Pool.get(i).md5;
	}

	private String jmd5() {
		return md5Pool.get(j).md5;
	}

	private String pmd5() {
		return md5Pool.get(p).md5;
	}

}

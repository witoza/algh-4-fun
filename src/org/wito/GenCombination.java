package org.wito;

import java.util.Arrays;

public class GenCombination {

	private int[] univ;
	private int[] arr;
	private int id = 0;

	public GenCombination(int n, int k) {
		univ = new int[n];
		for (int i = 0; i < univ.length; i++) {
			univ[i] = i + 1;
		}
		arr = new int[k];
	}

	void gen(int k, int lastId) {
		if (k == arr.length) {
			id++;
			System.out.println("#" + id + " -> " + Arrays.toString(arr));
			return;
		}
		for (int m = lastId; m < univ.length; m++) {
			arr[k] = univ[m];
			gen(k + 1, m + 1);
		}
	}

	public static void main(String[] args) {
		GenCombination genc = new GenCombination(9, 4);
		genc.gen(0, 0);

	}
}

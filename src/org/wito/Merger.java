package org.wito;

import java.util.Arrays;

public class Merger {

	static int[] merge(int[] arr1, int[] arr2) {
		int[] res = new int[arr1.length + arr2.length];

		int a = 0;
		int ak = arr1.length;

		int b = 0;
		int bk = arr2.length;

		int pos = 0;
		while (a < ak || b < bk) {
			int val = -1;
			if (a < ak && b < bk) {
				if (arr1[a] > arr2[b]) {
					val = arr1[a++];
				} else {
					val = arr2[b++];
				}
			} else if (a < ak) {
				val = arr1[a++];
			} else {
				val = arr2[b++];
			}
			res[pos++] = val;
		}

		return res;

	}

	public static void main(String[] args) {
		int[] arr1 = { 3, 2, 1 };
		int[] arr2 = { 9, 8, 7, 6, 5, 0 };

		System.out.println(Arrays.toString(merge(arr1, arr2)));

	}
}

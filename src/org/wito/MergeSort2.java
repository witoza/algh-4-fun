package org.wito;

import java.util.Arrays;

public class MergeSort2 {

	static void mergeSort(int[] arr, int p, int q) {
		if (q - p <= 1) {
			return;
		}
		int r = p + (q - p) / 2;
		mergeSort(arr, p, r);
		mergeSort(arr, r, q);
		merge(arr, p, r, q);
	}

	private static void merge(int[] arr, int p, int r, int q) {
		int[] tmp = Arrays.copyOfRange(arr, p, r + 1);

		int a = 0;
		int ak = r - p - 1;

		int b = r;
		int bk = q - 1;

		int pos = p;

		while (a <= ak || b <= bk) {

			int val = -1;

			if (a <= ak && b <= bk) {
				if (tmp[a] > arr[b]) {
					val = tmp[a++];
				} else {
					val = arr[b++];
				}
			} else if (a <= ak) {
				val = tmp[a++];
			} else if (a <= bk) {
				val = arr[b++];
			}
			arr[pos++] = val;
		}

	}

	public static void main(String[] args) {
		int[] arr = new int[] { 6, 19, 5, 4, 1, 2, 3 };
		mergeSort(arr, 0, arr.length);
		System.out.println(Arrays.toString(arr));

	}
}

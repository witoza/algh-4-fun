package org.wito;

import java.util.Arrays;

public class MergeSort {

	static int d(int p, int q) {
		return q - p + 1;
	}

	static void mergeSort(int[] arr, int p, int q) {
		if (d(p, q) <= 1) {
			return;
		}
		int r = p + (q - p) / 2;
		mergeSort(arr, p, r);
		mergeSort(arr, r + 1, q);
		merge(arr, p, r, q);
	}

	private static void merge(int[] arr, int p, int r, int q) {
		int[] tmp = Arrays.copyOfRange(arr, p, r + 1);

		int a = 0;
		int ak = r - p;

		int b = r + 1;
		int bk = q;

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
		int[] arr = new int[] { 15, 17, 3, 2, 1, 9, 8, 7, 15, 43, 11, 2, 3, 88, 5, 2, 71, 51, 1, 222, 3, 4, 5, 6, 7, 76, 51 };
		mergeSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

	}
}

package org.wito;

public class BSearch {
	public static int bSearch(int[] arr, int p, int q, int val) {

		while (p <= q) {
			int mid = (p + q) / 2;

			if (val > arr[mid]) {
				p = mid + 1;
			} else if (val < arr[mid]) {
				q = mid - 1;
			} else if (val == arr[mid]) {
				return mid;
			}

		}

		return -1;
	}
}

package org.wito;

public class Sort {

	public static void quickSort(int arr[], int p, int q) {
		if (d(p, q) > 1) {
			int r = partition(arr, p, q);
			quickSort(arr, p, r - 1);
			quickSort(arr, r, q);
		}
	}

	private static int d(int p, int q) {
		return (q - p) + 1;
	}

	public static int kselect(int arr[], int p, int q, int k) {
		int dpk = d(p, q);
		if (dpk < k) {
			return -1;
		}
		if (d(p, q) == k && k == 1) {
			return p;
		}

		int r = partition(arr, p, q);

		int dl = d(p, r - 1);

		if (dl >= k) {
			return kselect(arr, p, r - 1, k);
		} else {
			return kselect(arr, r, q, k - dl);
		}

	}

	// a <= pivot <= b
	public static int partition(int arr[], int p, int q) {
		int i = p;
		int j = q;
		int pivot = arr[p];

		while (true) {
			while (i < q && arr[i] < pivot) {
				i++;
			}
			while (j > p && arr[j] > pivot) {
				j--;
			}
			if (i > j) {
				return i;
			}
			Utils.swap(arr, i, j);
			i++;
			j--;
		}

	}
}

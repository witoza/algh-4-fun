package org.wito;

public class Partition {
	static int partition(int[] arr, int p, int q, int pivot) {

		int i = p;
		int j = q;
		while (i < j) {
			while (i < q && arr[i] < pivot) {
				i++;
			}
			while (j > p && arr[j] > pivot) {
				j--;
			}
			if (i < j) {
				Utils.swap(arr, i, j);
				i++;
				j--;
			}

		}
		return i;
	}

	static int partition(int[] arr, int p, int q) {
		return partition(arr, p, q, arr[p]);
	}

	public static void main(String[] args) {
		// int arr[] = new int[] { 2, 9, 7, 3, 4, 6 };
		// int idx = partition(arr, 0, arr.length - 1, 4);
		// System.out.println(idx);
		// System.out.println(Arrays.toString(arr));

		int a = 1;
		int b = 2;
		if (a == 2 || a == 1 && b == 3) {
			System.out.println("ye");
		} else {
			System.out.println("not");
		}

	}
}

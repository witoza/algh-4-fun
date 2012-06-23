package org.wito;

public class Utils {

	public static void swap(int[] buff, int i, int j) {
		int tmp = buff[i];
		buff[i] = buff[j];
		buff[j] = tmp;
	}

	public static void insertAt(int[] buff, int pos, int val) {
		for (int i = buff.length - 1; i > pos; i--) {
			buff[i] = buff[i - 1];
		}
		buff[pos] = val;
	}

	public static void deleteAt(int[] buff, int pos) {
		for (int i = pos; i < buff.length - 1; i++) {
			buff[i] = buff[i + 1];
		}
	}

	public static int[] getIdentity(int n) {
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = i + 1;
		}
		return arr;
	}

	public static void reverse(int[] buff, int pos) {
		int i = pos;
		int j = buff.length - 1;
		while (j > i) {
			swap(buff, i, j);
			i++;
			j--;
		}

	}
}

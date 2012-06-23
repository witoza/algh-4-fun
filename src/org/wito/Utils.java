package org.wito;

import java.util.Random;

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

	public static int[] getIdentity(int n, int k) {
		int[] arr = new int[n * k];
		for (int j = 0; j < k; j++) {
			for (int i = 0; i < n; i++) {
				arr[j * n + i] = 1 + j;
			}
		}
		return arr;
	}

	public static boolean isSortedInc(int[] arr) {
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > arr[i + 1]) {
				return false;
			}
		}
		return true;
	}

	public static int[] getRandArray(int n) {
		int[] arr = new int[n];
		Random rng = new Random();
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rng.nextInt(1000);
		}
		return arr;
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

package org.wito;

public class GenSubsets {

	private static void genAll(int[] arr, int i) {
		if (arr.length == i) {
			print(arr);
			return;
		}

		int v = arr[i];
		genAll(arr, i + 1);
		arr[i] = 0;
		genAll(arr, i + 1);
		arr[i] = v;
	}

	private static void print(int[] arr) {
		String str = "";
		for (int i : arr) {
			if (i == 0) {
				continue;
			}
			str = str + " " + i;
		}
		System.out.println(str);
	}

	public static void main(String[] args) {
		genAll(Utils.getIdentity(3), 0);
	}

}

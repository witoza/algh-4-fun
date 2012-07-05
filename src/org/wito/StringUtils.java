package org.wito;

import java.util.Arrays;

public class StringUtils {
	static void reverse(char[] arr) {

		int i = 0;
		int j = 0;
		for (int k = 0; k < arr.length; k++) {
			if (arr[k] == '\0') {
				j = k - 1;
				break;
			}
		}
		while (i < j) {
			char c = arr[i];
			arr[i] = arr[j];
			arr[j] = c;
			i++;
			j--;
		}
	}

	public static void main(String[] args) {
		char[] arr = new char[] { 'a', 'b', 'c', 'd', '\0' };
		reverse(arr);
		System.out.println(Arrays.toString(arr));
	}
}

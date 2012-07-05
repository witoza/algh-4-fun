package org.wito;

import java.util.Arrays;

public class PascalTriangle {
	public static void main(String[] args) {

		int[] parr = new int[] { 1, 0 };
		for (int i = 1; i < 11; i++) {
			System.out.println(Arrays.toString(parr));
			int[] narr = new int[parr.length + 1];
			narr[0] = parr[0];
			for (int j = 1; j < narr.length - 1; j++) {
				narr[j] = parr[j] + parr[j - 1];
			}
			narr[narr.length - 1] = 0;
			parr = narr;
		}

	}
}

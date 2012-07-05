package org.wito;

import java.util.Arrays;

public class MatrixMultiply {

	// [row, col]
	public static int[][] multiply(int[][] A, int[][] B) {
		int p = A.length;
		int q1 = A[0].length;
		int q2 = B.length;
		int r = B[0].length;

		if (q1 != q2) {
			throw new IllegalArgumentException("invalid matrices size");
		}

		int[][] R = new int[p][r];

		for (int k = 0; k < p; k++) {
			for (int i = 0; i < r; i++) {
				for (int j = 0; j < q1; j++) {
					R[k][i] += A[k][j] * B[j][i];
				}
			}
		}

		return R;

	}

	private static void print(int[][] mr) {
		System.out.println("{");
		for (int i = 0; i < mr.length; i++) {
			System.out.println(Arrays.toString(mr[i]));
		}
		System.out.println("}");

	}

	public static void main(String[] args) {
		int[][] m1 = new int[][] { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
		int[][] mr = multiply(m1, m1);
		print(mr);

	}

}

package org.wito;

import java.util.Random;

public class RandSampling {

	public static void suffle(int[] arr) {
		Random rng = new Random();
		for (int i = 0; i < arr.length; i++) {
			int n = i + rng.nextInt(arr.length - i);
			Utils.swap(arr, i, n);
		}
	}
}

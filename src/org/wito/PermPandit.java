package org.wito;

import java.util.Arrays;

public class PermPandit {

	boolean next(int[] perm) {

		int k = -1;
		for (int i = 0; i < perm.length - 1; i++) {
			if (perm[i] < perm[i + 1]) {
				k = i;
			}
		}
		if (k == -1) {
			return false;
		}

		int l = perm.length - 1;
		while (perm[l] < perm[k]) {
			l--;
		}
		Utils.swap(perm, k, l);
		Utils.reverse(perm, k + 1);
		return true;
	}

	void genAll(int n) {
		int[] arr = Utils.getIdentity(n);
		do {
			System.out.println(Arrays.toString(arr));
		} while (next(arr));
	}

}

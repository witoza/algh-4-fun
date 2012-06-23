package org.wito;

public class PermJohnson {
	static class Nbr {
		int value;
		int dir;

		public Nbr(int value, int dir) {
			this.value = value;
			this.dir = dir;
		}

	}

	void print(Nbr[] perm) {
		String str = "";
		for (int i = 0; i < perm.length; i++) {
			str = str + " ";
			if (perm[i].dir == 1) {
				str = str + "<" + perm[i].value;
			} else {
				str = str + perm[i].value + ">";
			}
		}
		System.out.println(str.substring(1));
	}

	static <T> void swap(T[] buff, int i, int j) {
		T tmp = buff[i];
		buff[i] = buff[j];
		buff[j] = tmp;
	}

	boolean next(Nbr[] perm) {
		int max = -1;
		for (int i = 0; i < perm.length; i++) {

			if (max != -1 && perm[i].value < perm[max].value) {
				continue;
			}
			if (perm[i].dir == 1) {
				if (i == 0) {
					continue;
				}
				if (perm[i - 1].value < perm[i].value) {
					max = i;
				}
			} else {
				if (i == perm.length - 1) {
					continue;
				}
				if (perm[i + 1].value < perm[i].value) {
					max = i;
				}
			}
		}
		if (max == -1) {
			return false;
		}

		int maxValue = perm[max].value;

		if (perm[max].dir == 1) {
			swap(perm, max, max - 1);
		} else {
			swap(perm, max, max + 1);
		}

		for (int i = 0; i < perm.length; i++) {
			if (perm[i].value > maxValue) {
				perm[i].dir = 1 - perm[i].dir;
			}
		}
		return true;
	}

	void genAll(int n) {
		Nbr[] arr = new Nbr[n];
		for (int i = 0; i < n; i++) {
			arr[i] = new Nbr(i + 1, 1);
		}

		do {
			print(arr);
		} while (next(arr));
	}
}

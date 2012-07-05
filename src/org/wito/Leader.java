package org.wito;

public class Leader {

	static int getLeader(int[] arr) {
		int candidate = arr[0];
		int count = 0;

		for (int e : arr) {
			if (e == candidate) {
				count++;
			} else {
				count--;
				if (count == 0) {
					candidate = e;
				}
			}

		}

		count = 0;
		for (int e : arr) {
			if (e == candidate) {
				count++;
			}
		}

		if (count > arr.length / 2) {
			return candidate;
		}
		return -1;
	}
}

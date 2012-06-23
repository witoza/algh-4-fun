package org.wito;

import java.util.Arrays;

import org.junit.Test;

public class BSearchTest {

	@Test
	public void testBSearch() {
		int[] arr = Utils.getRandArray(20);
		Sort.quickSort(arr, 0, arr.length - 1);
		System.out.println(Arrays.toString(arr));

		for (int i = 0; i < arr.length; i++) {
			System.out.println("searching for " + arr[i]);
			int pos = BSearch.bSearch(arr, 0, arr.length - 1, arr[i]);
			System.out.println("pos = " + pos);
			System.out.println("val = " + arr[pos]);
		}

	}

}

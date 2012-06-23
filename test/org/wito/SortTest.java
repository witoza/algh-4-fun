package org.wito;

import java.util.Arrays;

import junit.framework.Assert;

import org.junit.Test;

public class SortTest {

	@Test
	public void testKselect() {
		int size = 200;
		int[] id = Utils.getIdentity(size);

		for (int k = 1; k < id[id.length - 1]; k++) {
			int[] arr = Utils.getIdentity(size);
			RandSampling.suffle(arr);
			int pos = Sort.kselect(arr, 0, arr.length - 1, k);
			Assert.assertEquals(id[pos], arr[pos]);
		}
	}

	@Test
	public void testQuickSort() {
		int[] arr = Utils.getIdentity(500, 5);
		RandSampling.suffle(arr);
		Sort.quickSort(arr, 0, arr.length - 1);
		Assert.assertTrue(Utils.isSortedInc(arr));
	}

	@Test
	public void testPartition1() {
		int[] arr = new int[] { 5, 4, 5, 2, 7, 8, 9, 5, 1 };
		int r = Sort.partition(arr, 0, arr.length - 1);
		org.junit.Assert.assertArrayEquals(new int[] { 1, 4, 5, 2, 7, 8, 9, 5, 5 }, arr);
		Assert.assertEquals(4, r);
	}

	@Test
	public void testPartition2() {
		int[] arr = new int[] { 5, 5, 5, 5, 4, 4, 4 };
		int r = Sort.partition(arr, 0, arr.length - 1);
		org.junit.Assert.assertArrayEquals(new int[] { 4, 4, 4, 5, 5, 5, 5 }, arr);
		Assert.assertEquals(4, r);
	}
}

package org.wito;

import java.util.Arrays;

import org.junit.Test;

public class RandSamplingTest {
	@Test
	public void sampleTest() {
		int[] arr = Utils.getIdentity(10);
		RandSampling.suffle(arr);
		System.out.println(Arrays.toString(arr));

	}
}

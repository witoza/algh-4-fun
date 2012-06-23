package org.wito;

import org.junit.Test;

public class GenSubsetsTest {

	@Test
	public void testGenAll() {
		GenSubsets.genAll(Utils.getIdentity(3), 0);
	}

}

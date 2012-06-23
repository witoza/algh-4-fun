package org.wito;

import org.junit.Test;

public class SListTest {

	@Test
	public void testReverse() {

		SList<Integer> ml = new SList<Integer>();
		ml.add(1);
		ml.add(21);
		ml.add(311);
		ml.add(4111);
		ml.add(51111);

		ml.print();
		ml.reverse3();
		ml.print();
		ml.reverse3();
		ml.print();
	}
}

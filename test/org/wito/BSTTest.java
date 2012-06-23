package org.wito;

import org.junit.Test;

public class BSTTest {

	@Test
	public void sampleTest() {
		BST<Integer> bst = new BST<Integer>();
		bst.add(30, 60, 70, 80, 90, 12, 5, 6, 7, 8, 9, 100, 200, 300, 56, 57,
				58);
		bst.getInOrder();
		bst.findAndPrint(10);
		bst.findAndPrint(99);
		bst.findAndPrint(101);
		bst.findAndPrint(100);
		bst.findAndPrint(57);
		bst.printMinMan();

		bst.printInOrderUsingSucc();
		bst.printInOrderUsingPred();

		bst.delete(30, 70, 80, 90, 12, 5, 6, 7, 8, 9, 100, 200, 300, 56, 57,
				58, 60);

		bst.printInOrderUsingPred();

	}
}

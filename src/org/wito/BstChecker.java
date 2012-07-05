package org.wito;

class Node {
	int value;
	Node l, r;
}

public class BstChecker {
	static boolean isBST(Node node) {
		if (node == null) {
			return true;
		}

		if (node.r != null) {
			if (node.value > node.r.value) {
				return false;
			}
			if (!isBST(node.r)) {
				return false;
			}
		}

		if (node.l != null) {
			if (node.value < node.l.value) {
				return false;
			}
			if (!isBST(node.l)) {
				return false;
			}
		}

		return true;

	}
}

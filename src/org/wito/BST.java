package org.wito;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BST<T extends Comparable<T>> {
	public static class Node<T> {
		Node<T> parent, l, r;
		public T value;

		public Node(T value) {
			this.value = value;
		}

		@Override
		public String toString() {
			return "" + value + "";
		}

	}

	private Node<T> root;

	private void addImpl(Node<T> node, T val) {
		if (node.value.compareTo(val) > 0) {
			if (node.l == null) {
				node.l = new Node<T>(val);
				node.l.parent = node;
			} else {
				addImpl(node.l, val);
			}
		} else {
			if (node.r == null) {
				node.r = new Node<T>(val);
				node.r.parent = node;
			} else {
				addImpl(node.r, val);
			}
		}
	}

	private void deleteInternal(Node<T> node) {
		boolean hasLeft = node.l != null;
		boolean hasRight = node.r != null;

		if (!hasRight && !hasLeft) {
			if (node.parent.l == node) {
				node.parent.l = null;
			} else {
				node.parent.r = null;
			}
		} else if (!hasRight && hasLeft) {
			node.l.parent = node.parent;
			if (node.parent.l == node) {
				node.parent.l = node.l;
			} else {
				node.parent.r = node.l;
			}
		} else if (hasRight && !hasLeft) {
			node.r.parent = node.parent;
			if (node.parent.l == node) {
				node.parent.l = node.r;
			} else {
				node.parent.r = node.r;
			}
		} else if (hasRight && hasLeft) {
			Node<T> succ = minImpl(node.r);
			node.value = succ.value;
			deleteInternal(succ);
		}
	}

	private void deleteRoot() {
		boolean hasLeft = root.l != null;
		boolean hasRight = root.r != null;

		if (!hasRight && !hasLeft) {
			root = null;
		} else if (!hasRight && hasLeft) {
			root = root.l;
			root.parent = null;
		} else if (hasRight && !hasLeft) {
			root = root.r;
			root.parent = null;
		} else if (hasRight && hasLeft) {
			Node<T> succ = minImpl(root);
			root.value = succ.value;
			deleteInternal(succ);
		}
	}

	public void delete(T... vals) {
		for (T val : vals) {
			Node<T> node = find(val);
			if (node == null) {
				continue;
			} else if (node == root) {
				deleteRoot();
			} else {
				deleteInternal(node);
			}
		}
	}

	public void add(T val) {
		if (root == null) {
			root = new Node<T>(val);
		} else {
			addImpl(root, val);
		}
	}

	public void add(T... vals) {
		for (T val : vals) {
			add(val);
		}
	}

	private Node<T> findImpl(Node<T> node, T val) {
		if (node == null) {
			return null;
		}
		if (node.value.compareTo(val) == 0) {
			return node;
		} else if (node.value.compareTo(val) > 0) {
			// val < node.value ==> search in left subtree
			if (node.l == null) {
				return node;
			}
			return findImpl(node.l, val);
		} else {
			// val > node.value ==> search in right subtree
			if (node.r == null) {
				return node;
			}
			return findImpl(node.r, val);
		}
	}

	public void findAndPrint(T val) {
		System.out.println("Finding for " + val + " -> " + find(val));
	}

	public Node<T> find(T val) {
		return findImpl(root, val);
	}

	private Node<T> maxImpl(Node<T> node) {
		if (node.r == null) {
			return node;
		} else {
			return maxImpl(node.r);
		}

	}

	public Node<T> max() {
		if (root == null) {
			return null;
		}
		return maxImpl(root);
	}

	private Node<T> minImpl(Node<T> node) {
		if (node.l == null) {
			return node;
		} else {
			return minImpl(node.l);
		}

	}

	public void printMinMan() {
		System.out.println("Min = " + min() + ", Max = " + max());
	}

	public Node<T> min() {
		if (root == null) {
			return null;
		}
		return minImpl(root);
	}

	public Node<T> succ(Node<T> curr) {

		Node<T> son = null;
		while (curr != null) {
			if (son != null && curr.l == son) {
				return curr;
			}
			if (curr.r != son && curr.r != null) {
				return minImpl(curr.r);
			}
			son = curr;
			curr = curr.parent;
		}
		return null;
	}

	public Node<T> pred(Node<T> curr) {

		Node<T> son = null;
		while (curr != null) {
			if (son != null && curr.r == son) {
				return curr;
			}
			if (curr.l != son && curr.l != null) {
				return maxImpl(curr.l);
			}
			son = curr;
			curr = curr.parent;
		}
		return null;
	}

	public void printInOrderUsingSucc() {
		System.out.print("tree = [");
		Node<T> node = min();
		while (node != null) {
			System.out.print(node + ", ");
			node = succ(node);
		}
		System.out.println("]");
	}

	private List<Node<T>> getInOrderImpl(Node<T> node) {
		if (node == null) {
			return Collections.emptyList();
		}
		List<Node<T>> res = new ArrayList<Node<T>>();
		res.addAll(getInOrderImpl(node.l));
		res.add(node);
		res.addAll(getInOrderImpl(node.r));
		return res;

	}

	public List<Node<T>> getInOrder() {
		return getInOrderImpl(root);
	}

	public void printInOrderUsingPred() {
		Node<T> node = max();
		System.out.print("tree = [");
		while (node != null) {
			System.out.print(node + ", ");
			node = pred(node);
		}
		System.out.println("]");

	}

}

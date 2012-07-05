package org.wito;

public class Bitmap {

	static enum Color {
		Black, White, Mixed
	}

	static class Node {
		Color color;// 0, 1, -1
		Node n[] = new Node[4];

		public Node(Color color) {
			this.color = color;
		}

		public void prune(Color color) {
			this.color = color;
			for (int i = 0; i < n.length; i++) {
				n[i] = null;
			}
		}

		public void normalize() {
			int blacks = 0;
			int whites = 0;
			int mixed = 0;

			for (int i = 0; i < n.length; i++) {
				if (n[i] == null) {
					continue;
				}
				n[i].normalize();
				Color c = n[i].color;
				if (c == Color.White) {
					whites++;
				} else if (c == Color.Black) {
					blacks++;
				} else {
					mixed++;
				}
			}

			if (blacks == 0 && whites == 0 && mixed == 0) {
				if (color == Color.Mixed) {
					throw new IllegalStateException("Color on a leaf is Mixed");
				}
				return;
			}

			if (mixed > 0) {
				color = Color.Mixed;
			} else if (blacks > 0 && whites > 0) {
				color = Color.Mixed;
			} else if (whites > 0) {
				prune(Color.White);
			} else if (blacks > 0) {
				prune(Color.Black);
			} else {
				throw new IllegalStateException("Illegal state on a node: mixed=" + mixed + ", blacks=" + blacks + ", whites=" + whites);
			}
		}
	}

	private static void joinImpl(Node bitmap1, Node bitmap2) {
		if (bitmap2.color == Color.White) {
			return;
		} else if (bitmap2.color == Color.Black) {
			bitmap1.prune(Color.Black);
		} else {
			for (int i = 0; i < bitmap1.n.length; i++) {
				if (bitmap2.n[i] == null) {
					continue;
				} else if (bitmap1.n[i] == null) {
					bitmap1.n[i] = deepCopy(bitmap2.n[i]);
				} else {
					joinImpl(bitmap1.n[i], bitmap2.n[i]);
				}
			}
		}
	}

	private static Node deepCopy(Node node) {
		if (node == null) {
			return null;
		}
		Node newOne = new Node(node.color);
		for (int i = 0; i < node.n.length; i++) {
			newOne.n[i] = deepCopy(node.n[i]);
		}
		return newOne;
	}

	public static void join(Node bitmap1, Node bitmap2) {
		if (bitmap1 == null || bitmap2 == null) {
			throw new IllegalArgumentException();
		}
		bitmap1.normalize();
		bitmap2.normalize();
		joinImpl(bitmap1, bitmap2);
		bitmap1.normalize();
		bitmap2.normalize();
	}

	public static void main(String[] args) {
		Node bmp1 = new Node(Color.Mixed);
		bmp1.n[0] = new Node(Color.Black);
		bmp1.n[1] = new Node(Color.White);
		bmp1.n[2] = new Node(Color.Black);
		bmp1.n[3] = new Node(Color.White);

		Node bmp2 = new Node(Color.Mixed);
		bmp2.n[0] = new Node(Color.Black);
		bmp2.n[1] = new Node(Color.White);
		bmp2.n[2] = new Node(Color.Black);
		bmp2.n[3] = new Node(Color.White);

		join(bmp1, bmp2);

	}

}

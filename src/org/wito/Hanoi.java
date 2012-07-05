package org.wito;

import java.util.Stack;

class Rod {
	final Stack<Integer> nbrs = new Stack<Integer>();
	final int id;

	public Rod(int id) {
		this.id = id;
	}
}

public class Hanoi {
	int moveNbr = 0;

	void move(int n, Rod from, Rod to, Rod using) {
		if (n == 1) {
			int weight = from.nbrs.pop();
			moveNbr++;
			System.out.println("#" + moveNbr + ". Moving disc with size " + weight + " from: " + from.id + " to " + to.id);
			to.nbrs.push(weight);
			return;
		}
		move(n - 1, from, using, to);
		move(1, from, to, using);
		move(n - 1, using, to, from);

	}

	void solve(int n) {
		Rod[] rod = new Rod[3];
		for (int i = 0; i < rod.length; i++) {
			rod[i] = new Rod(i);
		}
		for (int i = 0; i < n; i++) {
			rod[0].nbrs.push(n - i);
		}
		move(n, rod[0], rod[2], rod[1]);
	}

	public static void main(String[] args) {

		Hanoi hanoi = new Hanoi();
		hanoi.solve(4);
	}

}

package org.wito;

public class Heap {
	private int[] arr = new int[100];
	private int size = 1;

	public Heap() {
	}

	public Heap(int... values) {
		for (int value : values) {
			size++;
			arr[size - 1] = value;
		}
		for (int i = size / 2; i > 0; i--) {
			siftDown(i);
		}
		assertIsHeap();
	}

	public void extractAllMinsAndPrint() {
		while (!isEmpty()) {
			System.out.print(extractMin() + ", ");
		}
		System.out.println();
	}

	public void add(int... values) {
		for (int value : values) {
			int pos = size;
			size++;
			arr[pos] = value;
			siftUp(pos);
		}
		assertIsHeap();
	}

	private void siftUp(int id) {
		int parent = id / 2;
		if (parent > 0 && arr[parent] > arr[id]) {
			Utils.swap(arr, id, parent);
			siftUp(parent);
		}
	}

	private void siftDown(int id) {
		int lid = id * 2;
		int rid = id * 2 + 1;

		int parent = id;

		if (lid < size && arr[lid] < arr[id]) {
			id = lid;
		}
		if (rid < size && arr[rid] < arr[id]) {
			id = rid;
		}

		if (parent != id) {
			Utils.swap(arr, parent, id);
			siftDown(id);
		}

	}

	private void assertIsHeap() {
		for (int i = 1; i < size; i++) {
			int lid = i * 2;
			int rid = i * 2 + 1;

			if (rid < size && arr[i] > arr[rid]) {
				System.err.println("heap property violated at index " + i + ": " + arr[i] + "<" + arr[rid]);
			}
			if (lid < size && arr[i] > arr[lid]) {
				System.err.println("heap property violated at index " + i + ": " + arr[i] + "<" + arr[lid]);
			}

		}

	}

	private void assertNotEmpty() {
		if (isEmpty()) {
			throw new IllegalStateException("queue is empty");
		}
	}

	public int getMin() {
		assertNotEmpty();
		return arr[0];
	}

	public boolean isEmpty() {
		return !(size > 1);
	}

	public int extractMin() {
		assertNotEmpty();
		int res = arr[1];
		arr[1] = arr[size - 1];
		size--;
		siftDown(1);
		assertIsHeap();
		return res;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("heap(" + (size - 1) + "): ");
		for (int i = 1; i < size; i++) {
			sb.append(arr[i]).append(", ");
		}
		return sb.toString();
	}
}

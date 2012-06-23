package org.wito;

import org.junit.Test;

public class HeapTest {

	@Test
	public void test1() {
		Heap heap = new Heap();
		heap.add(50, 40, 30, 20, 90, 80, 70, 60, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		System.out.println(heap);
		heap.extractAllMinsAndPrint();

	}

	@Test
	public void test2() {
		Heap heap = new Heap(50, 40, 30, 20, 90, 80, 70, 60, 9, 8, 7, 6, 5, 4, 3, 2, 1);
		System.out.println(heap);
		heap.extractAllMinsAndPrint();
	}

}

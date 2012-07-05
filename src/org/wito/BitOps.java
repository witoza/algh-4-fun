package org.wito;

public class BitOps {
	public static void main(String[] args) {

		int set = 0;
		set |= (1 << 5);

		boolean isSet = (set &= (1 << 5)) > 0;

		System.out.println(isSet);

	}
}

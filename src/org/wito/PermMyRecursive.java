package org.wito;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class PermMyRecursive {

	Set<String> all = new HashSet<String>();

	void gen(int[] buff, int act) {
		int n = buff.length;
		if (n == act) {
			emit(buff);
			return;
		}
		for (int r = 0; r < act + 1; r++) {
			Utils.insertAt(buff, r, (act + 1));
			gen(buff, act + 1);
			Utils.deleteAt(buff, r);
		}
	}

	void emit(int[] buff) {
		String str = Arrays.toString(buff);
		all.add(str);
		System.out.println(all.size() + " --> " + str);
	}

	Set<String> genAll(int n) {
		int[] buff = new int[n];
		gen(buff, 0);
		return all;
	}
}

package org.wito;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermMyIter {

	List<String> genWords(String word, int n) {
		List<String> res = new ArrayList<String>();
		for (int k = 0; k < word.length() + 1; k++) {
			res.add(word.substring(0, k) + n + word.substring(k));
		}
		return res;
	}

	void genAll(int n) {
		Set<String> prev = new HashSet<String>();
		prev.add("");

		for (int i = 0; i < n; i++) {
			Set<String> next = new HashSet<String>();
			for (String word : prev) {
				next.addAll(genWords(word, i + 1));
			}
			prev = next;
		}

		System.out.println(prev);
	}

}
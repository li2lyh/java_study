package ch11_collections;

import java.util.*;

public class CompartorEx {
	public static void main(String[] args) {
		String[] strArr = { "cat", "Dog", "lion", "tiger" };

		Arrays.sort(strArr); // String의 comrable구현에 의한 정렬
		System.out.println("strArr=" + Arrays.toString(strArr));

		Arrays.sort(strArr, String.CASE_INSENSITIVE_ORDER); // 대소문자 구분안함
		System.out.println("strArr=" + Arrays.toString(strArr));

		Arrays.sort(strArr, new Desending()); // 역순정렬
		System.out.println("strArr=" + Arrays.toString(strArr));
	}
}

class Desending implements Comparator {
	public int compare(Object o1, Object o2) {
		if (o1 instanceof Comparable && o2 instanceof Comparable) {
			Comparable c1 = (Comparable) o1;
			Comparable c2 = (Comparable) o2;
			return c1.compareTo(c2) * -1; // -1을 곱해서 기본 정렬 방식의 역으로 변경.
											// 또는 c2.compareTo(c1)와 같이 순서를 바꿔도 됨
		}
		return -1;
	}
}

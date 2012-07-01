package ch13.ex13_02;

public class Counter {
	public static int getCharactorCount(String str, String target) {
		if (str.length() < target.length())
			return 0;

		int res = 0;

		for (int i = 0; i < str.length() - target.length() + 1; i++) {
			if(str.substring(i, i + target.length()).equals(target))
				res++;
		}

		return res;
	}

	public static void main(String[] args) {
		int a = Counter.getCharactorCount("aaabbbbbabaab", "ab");
		System.out.println(a);
	}
}

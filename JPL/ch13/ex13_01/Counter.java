package ch13.ex13_01;

public class Counter {
	public static int getCharactorCount(String str, char target) {
		int res = 0;

		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == target)
				res++;
		}

		return res;
	}

	public static void main(String[] args) {
		int a = Counter.getCharactorCount("abbbbb", 'a');
		System.out.println(a);
	}
}

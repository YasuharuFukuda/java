package ch22.ex22_05;

import java.util.ArrayList;
import java.util.List;

public class Main {
	private static ArrayList<Dice> al = new ArrayList<Dice>();
	private static int diceCount = 2;
	private static int shakeTimes = 120;
	private static int expected = 7;


	public static void main(String[] args) {
		List<Dice> ds = new ArrayList<Dice>();
		for(int i = 0; i < diceCount; i++) {
			ds.add(new Dice());
		}

		List<Integer> results = new ArrayList<Integer>();

		for(int i = 0; i < shakeTimes; i++) {
			int result = 0;
			for(Dice d :ds) {
				result += d.shake();
			}
			results.add(result);
		}

		int count = 0;
		for(int r : results) {
			if(r == expected)
				count++;
		}

		System.out.println(diceCount + "個のさいころを" + shakeTimes + "回振って合計" + "expected" + "が出るのは" + count + "回");


	}
}

package ch22.ex22_06;

import java.util.Map;
import java.util.Random;
import java.util.TreeMap;

public class Gaussian {
	private static final int TIMES = 1000;

	public static void eval() {
		Random random = new Random();
		Map<String, Integer> map = new TreeMap<String, Integer>();

		for (int i = 0; i < TIMES; i++) {
			double d = random.nextGaussian();
			String key = String.format("%.1f", d);
			if (map.get(key) != null) {
				map.put(key, map.get(key) + 1);
			} else {
				map.put(key, 1);
			}
		}

		for(Map.Entry<String, Integer> e : map.entrySet()) {
			System.out.print(e.getKey());
			for(int i = 0; i < e.getValue(); i++){
				System.out.print("*");
			}
			System.out.println("");
		}
	}

	public static void main(String[] args) {
		Gaussian.eval();
	}
}

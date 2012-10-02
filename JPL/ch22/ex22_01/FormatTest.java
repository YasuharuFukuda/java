package ch22.ex22_01;

import java.util.Formatter;

public class FormatTest {
	public static void main(String[] args) {
		double[] ds = { 3.0001, 3.2211, 5000.43425, 452738764.000325235252 };
		format(ds, 4);
	}

	public static void format(double[] values, int column) {
		for (int i = 0; i < column; i++) {
			System.out.printf("%.20f%n", values[i]);
		}
	}
}

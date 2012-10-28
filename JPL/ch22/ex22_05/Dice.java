package ch22.ex22_05;

import java.util.Random;

public class Dice {
	private Random r = new Random();

	public int shake() {
		return (short)(r.nextInt(6) + 1);
	}
}

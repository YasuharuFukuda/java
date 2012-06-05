package ch03.ex03_05;

public class LoopBenchmark extends Benchmark{
	void benchmark() {
	}

	void benchmark(int count) {
		for (int i = 0; i < count; i++) {

		}
	}

	public static void main(String[] args) {
		int count = Integer.parseInt(args[0]);
		long time = new LoopBenchmark().repeat(count);
		System.out.println(count + "methods in " + time + "ナノ秒");
	}
}

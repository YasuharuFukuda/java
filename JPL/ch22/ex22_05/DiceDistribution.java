//package ch22.ex22_05;
//
//import java.util.HashMap;
//import java.util.Map;
//
//public class DiceDistribution {
//	private static int size = 2;
//	private static int min = size;
//	private static int max = size * 6;
//
//	public static void printDistribution() {
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		for (int i = min; i <= max; i++) {
//			int total = 0;
//			int count = 0;
//
//			for(int j = 0; j < size; j++) {
//
//				for(int k = 1; k <= 6; k++){
//
//					total += k;
//				}
//			}
//
//			System.out.println("合計: " + i + ": " + count + " / " + (int)Math.pow(6.0, size));
//
//
//		}
//	}
//}

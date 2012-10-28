package ch22.ex22_14;

import java.util.StringTokenizer;

public class FloatingPointTokenizer {
	  public static double sum(String str) {
		  StringTokenizer tokens = new StringTokenizer(str, " ");
		  double sum = 0;
		  while (tokens.hasMoreTokens()) {
			  sum += Double.valueOf(tokens.nextToken());
		  }
		  return sum;
	  }

	  public static void main(String[] args) {
		  String str = "1.1 2.2 3.3 4.4";
		  System.out.println(sum(str));
	  }
}

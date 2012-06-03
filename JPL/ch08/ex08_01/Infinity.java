package ex08_01;

public class Infinity {
	public static void main(String[] args) {
		//正+正
		System.out.println(Double.POSITIVE_INFINITY + Double.POSITIVE_INFINITY);

		//正-正
		System.out.println(Double.POSITIVE_INFINITY - Double.POSITIVE_INFINITY);

		//正*正
		System.out.println(Double.POSITIVE_INFINITY * Double.POSITIVE_INFINITY);

		//正/正
		System.out.println(Double.POSITIVE_INFINITY / Double.POSITIVE_INFINITY);


		//負+負
		System.out.println(Double.NEGATIVE_INFINITY + Double.NEGATIVE_INFINITY);

		//負-負
		System.out.println(Double.NEGATIVE_INFINITY - Double.NEGATIVE_INFINITY);


		//負*負
		System.out.println(Double.NEGATIVE_INFINITY * Double.NEGATIVE_INFINITY);


		//負/負
		System.out.println(Double.NEGATIVE_INFINITY / Double.NEGATIVE_INFINITY);

		//正+負
		System.out.println(Double.POSITIVE_INFINITY + Double.NEGATIVE_INFINITY);

		//正-負
		System.out.println(Double.POSITIVE_INFINITY - Double.NEGATIVE_INFINITY);

		//正*負
		System.out.println(Double.POSITIVE_INFINITY * Double.NEGATIVE_INFINITY);

		//正/負
		System.out.println(Double.POSITIVE_INFINITY / Double.NEGATIVE_INFINITY);


	}
}

package ex03_02;

public class X {
	protected int xMask = 0x00ff;
	protected int fullMask;

	{
		System.out.println("----------X初期化ブロック--------------");
		printXMask();
		printFullXMask();
	}

	public X() {
		System.out.println("----------Xコンストラクタ1--------------");
		printXMask();
		printFullXMask();
		fullMask = xMask;
		System.out.println("----------Xコンストラクタ2--------------");
		printXMask();
		printFullXMask();
	}

	public int mask(int orig) {
		return (orig & fullMask);
	}

	public final void printXMask() {
		System.out.printf("xMask: %x\n", xMask);
	}

	public final void printFullXMask() {
		System.out.printf("fullMask: %x\n", fullMask);
	}

	public static void main(String[] args) {
		new X();
	}

}

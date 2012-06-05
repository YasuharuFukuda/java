package ch03.ex03_02;

public class Y extends X{
	protected int yMask = 0xff00;

	{
		System.out.println("----------Y初期化ブロック--------------");
		printXMask();
		printYMask();
		printFullXMask();
	}

	public Y() {
		System.out.println("----------Yコンストラクタ1--------------");
		printXMask();
		printYMask();
		printFullXMask();
		fullMask |= yMask;
		System.out.println("----------Yコンストラクタ2--------------");
		printXMask();
		printYMask();
		printFullXMask();

	}

	public final void printYMask() {
		System.out.printf("yMask: %x\n", yMask);
	}

	public static void main(String[] args) {
		new Y();
	}

}

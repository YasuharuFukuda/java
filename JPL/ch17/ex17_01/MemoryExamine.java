package ch17.ex17_01;

public class MemoryExamine {

	public static void main(String[] args) {
		printMemory();
		createObjexcts();
		printMemory();
		Runtime.getRuntime().gc();
		printMemory();

	}

	public static void printMemory(){
		System.out.println(Runtime.getRuntime().freeMemory());
	}

	public static void createObjexcts() {
		String aaa;
		for(int i = 0; i < 100000; i++)
			aaa = new String(String.valueOf(i));
	}

}


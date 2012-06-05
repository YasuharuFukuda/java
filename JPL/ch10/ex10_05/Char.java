package ch10.ex10_05;

public class Char {
	public String space(char ch1, char ch2){
		 String spaceStr = "";

		char lch;
		char hch;

		if(ch1 > ch2) {
			lch = ch2;
			hch = ch1;
		} else {
			lch = ch1;
			hch = ch2;
		}
		for (char c = lch; c <= hch; c++) {
			spaceStr += String.valueOf(c);
		}

		return spaceStr;
	}

	public static void main(String[] args) {
		Char c = new Char();
		System.out.println(c.space('a', 'z'));

	}
}

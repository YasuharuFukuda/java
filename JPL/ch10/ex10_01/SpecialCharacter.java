package ex10_01;

public class SpecialCharacter {
	public String replace(String str) {
		String nstr = "";

		if(str.contains("n")   ||
			str.contains("t")  ||
			str.contains("b")  ||
			str.contains("r")  ||
			str.contains("f")  ||
			str.contains("\\") ||
			str.contains("\"") ||
			str.contains("\'") ) {
				nstr = str.replace("n", "\\n");
				nstr = nstr.replace("t", "\\t");
				nstr = nstr.replace("b", "\\b");
				nstr = nstr.replace("r", "\\r");
				nstr = nstr.replace("f", "\\f");
				nstr = nstr.replace("\\", "\\\\");
				nstr = nstr.replace("\'", "\\'");
				nstr = nstr.replace("\"", "\\\"");
			return nstr;
		}else
			return str;
	}

	public static void main(String[] args) {
		SpecialCharacter sc = new SpecialCharacter();

		System.out.println(sc.replace("ntbrf\\'"));
	}
}

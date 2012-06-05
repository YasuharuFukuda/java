package ch10.ex10_01;

public class SpecialCharacter {
	public String replace(String str) {
		String replaceStr = "";
        for (int i = 0; i < str.length(); i++) {
        	replaceStr += replaceChar(str.charAt(i));
        }
        return replaceStr;
	}

	public String replaceChar(char ch) {
		String replaceCh = "";
        if (ch == '\n') {
            return "\\n";
        }
        else if (ch == '\t') {
            return "\\t";
        }
        else if (ch == '\b') {
            return "\\b";
        }
        else if (ch == '\r') {
            return "\\r";
        }
        else if (ch == '\f') {
            return "\\f";
        }
        else if (ch == '\\') {
            return "\\\\";
        }
        else if (ch == '\'') {
            return "\\'";
        }
        else if (ch == '\"') {
            return "\\\"";
        }
        else {
            return String.valueOf((ch));
        }
	}

	public static void main(String[] args) {
		SpecialCharacter sc = new SpecialCharacter();

		System.out.println(sc.replace("\n\tbrf\\'"));
	}
}

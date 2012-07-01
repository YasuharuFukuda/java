package ch13.ex13_03;

import java.util.ArrayList;
import java.util.Iterator;

public class Trim {
	public static ArrayList delimitedString(String from, char start, char end) {
		String target = from;
		int startPos = target.indexOf(start);
		int endPos = target.indexOf(end);
		ArrayList res = new ArrayList();

		if (startPos == -1)
			return null;
		else if (endPos == -1) {
			res.add(target.substring(startPos));
			return res;
		}

		while(startPos != -1 || endPos != -1) {
			while (startPos > endPos) {
				endPos = target.indexOf(end, endPos);
				if (endPos == -1)
					break;
			}
			res.add(target.substring(startPos, endPos + 1));
			target = target.substring(endPos + 1);
			startPos = target.indexOf(start);
			endPos = target.indexOf(end);
		}
		return res;
	}

	public static void main(String[] args) {
		ArrayList<String> list = Trim.delimitedString("abcdefgabcdefgaaaabbbbbc", 'a', 'c');
		 for (String a : list) {
	            System.out.println(a);
	        }
	}
}

package ch22.ex22_12;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.Iterator;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class MyScanner {
	public static Attributed readAttrs(Reader source) {
		Scanner in = new Scanner(source);
		Attributed attrs = new AttributedImpl();
		String exp = "(.*)=(.*)";
		Pattern pat = Pattern.compile(exp);
		while (in.hasNext(pat)) {
			in.next(pat);
			String name, value;
			MatchResult match = in.match();
			name = match.group(1);
			value  = match.group(2);
			attrs.add(new Attr(name, value));
		}
		return attrs;
	}

	public static void main(String[] args)
			throws IOException {

		for (String fpath : args) {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(fpath));
				Attributed attrs = readAttrs(in);
				Iterator<Attr> it = attrs.attrs();
				while (it.hasNext()) {
					System.out.println(it.next());
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} finally {
				if (in != null)
					in.close();
			}
		}
	}
}

package ch22.ex22_13;

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
	public static Attributed readAttrs(Reader source) throws IOException {
		Scanner in = new Scanner(source);
		in.useDelimiter("=");
		AttributedImpl impl = new AttributedImpl();
		Attr attr = null;
		while (in.hasNext()) {
			String next = in.next();
			if (attr == null) {
				if (next.equals(""))
					throw new IOException("miss matched");
				attr = new Attr(next);
				in.useDelimiter("=|\n");
			} else {
				attr.setValue(next);
				impl.add(attr);
				attr = null;
				in.useDelimiter("=|\n");
			}
		}
		return impl;
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

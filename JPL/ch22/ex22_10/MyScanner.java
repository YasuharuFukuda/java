package ch22.ex22_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


//ageargaeg
//gargagr
public class MyScanner {
	private static final String COMMENT_PATTERNs = "//.*";

	static List<String> readlines(Readable source) {
		Scanner in = new Scanner(source);
		in.useDelimiter(COMMENT_PATTERNs);
		List<String> lines = new ArrayList<String>();

		while (in.hasNext()) {
			String line = in.next();
			if (!line.isEmpty())
				lines.add(line);
		}

		return lines;
	}

	public static void main(String[] args)
			throws IOException {

		for (String fpath : args) {
			FileReader in = null;
			try {
				in =  new FileReader(fpath);
				List<String> lines = readlines(in);
				for (String line : lines) {
					System.out.println(line);
				}
			} finally {
				if (in != null)
					in.close();
			}
		}
	}

}

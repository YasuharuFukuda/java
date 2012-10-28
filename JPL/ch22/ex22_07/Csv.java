package ch22.ex22_07;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.MatchResult;
import java.util.regex.Pattern;

public class Csv {
	static final int CELLS = 4;

	public static List<String[]> readCSVTable(Readable source, int cellNum)
			throws IOException {
		Scanner in = new Scanner(source);
		List<String[]> vals = new ArrayList<String[]>();

		StringBuilder _exp = new StringBuilder("^");
		for(int i = 0; i < cellNum; i++) {
			_exp.append("(.*),");
		}
		_exp.deleteCharAt(_exp.length() - 1);
		String exp = _exp.toString();

		Pattern pat = Pattern.compile(exp, Pattern.MULTILINE);
		while (in.hasNextLine()) {
			String line = in.findInLine(pat);
			if (line != null) {
				String[] cells = new String[cellNum];
				MatchResult match = in.match();
				for (int i = 0; i < cells.length; ++i)
					cells[i] = match.group(i + 1);
				vals.add(cells);
				in.nextLine(); // 改行を読み飛ばし
			} else {
				throw new IOException("input format error");
			}
		}
		IOException ex = in.ioException();
		if (ex != null)
			throw ex;

		return vals;
	}

	public static void main(String[] args)
			throws IOException {

		for (String fpath : args) {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(fpath));
				List<String[]> vals = readCSVTable(in, 3);

				for (String[] csv : vals) {
					for (int i = 0; i < csv.length; ++i)
						System.out.print(csv[i] + ",");
					System.out.println();
				}
			} finally {
				if (in != null)
					in.close();
			}
		}
	}
}

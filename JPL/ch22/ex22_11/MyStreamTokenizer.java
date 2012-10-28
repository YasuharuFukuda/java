package ch22.ex22_11;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.ArrayList;
import java.util.List;

public class MyStreamTokenizer {
	public static List<String[]> readCSVTable(Reader source)
			throws IOException {
		StreamTokenizer in = new StreamTokenizer(source);
		in.ordinaryChar(',');
		in.eolIsSignificant(true);
		List<String[]> vals = new ArrayList<String[]>();
		List<String> cells = new ArrayList<String>();

		int count = 0;
		while (in.nextToken() != StreamTokenizer.TT_EOF) {
			if (in.ttype == StreamTokenizer.TT_EOL) {  			// 改行
				vals.add(cells.toArray(new String[0]));
				cells = new ArrayList<String>();
				count = 0;
			} else if (in.ttype == StreamTokenizer.TT_WORD) { 	// 入力あり
				cells.add(in.sval);
				count = 0;
			} else { 											// 入力なし
				if(count == 1){
					cells.add(null);
					count = 0;
				}
				count++;
			}
		}
		vals.add(cells.toArray(new String[0]));
		return vals;
	}

	public static void main(String[] args)
			throws IOException {

		for (String fpath : args) {
			BufferedReader in = null;
			try {
				in = new BufferedReader(new FileReader(fpath));
				List<String[]> vals = readCSVTable(in);

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

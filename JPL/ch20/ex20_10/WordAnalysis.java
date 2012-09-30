package ch20.ex20_10;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class WordAnalysis {
	private HashMap<String, Integer> data = new HashMap<String, Integer>();

	public HashMap<String, Integer> analysis(Reader reader) throws IOException{
		StreamTokenizer in = new StreamTokenizer(reader);
		in.commentChar('#');
		in.ordinaryChar('/');

		while((in.nextToken() != StreamTokenizer.TT_EOF)){
			if(in.ttype == StreamTokenizer.TT_WORD) {
				if(data.get(in.sval) == null){
					data.put(in.sval, 1);
				} else {
					int count = data.get(in.sval);
					data.put(in.sval, ++count);
				}
			}
		}
		return data;
	}

	public static void main(String[] args) {
		FileReader fileIn = null;
		try {
			fileIn = new FileReader("JPL\\ch20\\ex20_10\\test.txt");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		WordAnalysis wa = new WordAnalysis();
		HashMap<String, Integer> _data = null;
		try {
			_data = wa.analysis(fileIn);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		for(Map.Entry<String, Integer> e: _data.entrySet()) {
			System.out.println(e.getKey() + " : " + e.getValue());
		}
	}

}

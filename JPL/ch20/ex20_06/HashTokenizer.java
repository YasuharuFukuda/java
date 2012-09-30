package ch20.ex20_06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StreamTokenizer;
import java.util.HashMap;
import java.util.Map;

public class HashTokenizer {
	private HashMap<String, Double> data = new HashMap<String, Double>();

	public void readAttrs(Reader reader) throws IOException{
		StreamTokenizer in = new StreamTokenizer(reader);
		in.commentChar('#');
		in.ordinaryChar('/');
		String key = null;
		while((in.nextToken() != StreamTokenizer.TT_EOF)){
			if(in.ttype == StreamTokenizer.TT_WORD) {
				key = in.sval;
			} else if (in.ttype == StreamTokenizer.TT_NUMBER) {
				if (data.get(key) == null)
					data.put(key, in.nval);
				else {
					double val = data.get(key);
					data.put(key, in.nval + val);
				}
			}
		}
	}

	public HashMap<String, Double> getData() {
		return data;
	}

	public static void main(String[] args) {
		HashTokenizer ht = new HashTokenizer();
		HashMap<String, Double> d = null;

		FileReader fileIn = null;
		try {
			fileIn = new FileReader("JPL\\ch20\\ex20_06\\test.txt");
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			ht.readAttrs(fileIn);
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		d = ht.getData();

		for(Map.Entry<String, Double> e : d.entrySet()){
			System.out.println(e.getKey() + " : " + e.getValue());
		}

	}
}

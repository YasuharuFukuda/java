package ch20.ex20_05;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.LineNumberReader;

public class Grep {
	public void withLineNumber(String fileName, String target) throws IOException{
		FileReader fileIn;
		try {
			fileIn = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
			return;
		}
		LineNumberReader rnl = new LineNumberReader(fileIn);
		String str;

		while ((str = rnl.readLine()) != null) {
			if (str.matches(".*" + target + ".*" )){
				System.out.println(rnl.getLineNumber() + " : " + str);
			}

		}
	}

	public static void main(String[] args) {
		Grep g = new Grep();
		try {
			g.withLineNumber("JPL\\ch20\\ex20_05\\test.txt", "hoge");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

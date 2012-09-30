package ch20.ex20_04;

import java.io.FilterReader;
import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

public class LineFiterReader extends FilterReader{

	public LineFiterReader(Reader r) {
		super(r);
	}

	public String readLine() throws IOException{
		StringBuffer sb = new StringBuffer();
		int read;
		while((read = super.read()) != -1) {
			byte b = (byte) read;
			if(b != '\n') {
				sb.append((char) b);
			} else
				break;

		}
		return sb.toString();

	}

	public static void main(String[] args) {
		LineFiterReader lf = new LineFiterReader(new StringReader("aaaabagaerg\nagraga"));
		try {
			System.out.println(lf.readLine());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

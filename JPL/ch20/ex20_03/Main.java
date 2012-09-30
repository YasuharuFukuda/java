package ch20.ex20_03;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Main {
	public static void main(String[] args) {
		byte[] raw = null;
		DecryptInputStream dis = new DecryptInputStream(System.in);
		EncryptOutputStream eos = new EncryptOutputStream(System.out);

		try {
			int encrypted = dis.read();
			System.out.println(encrypted);
			eos.write(encrypted);
			System.out.println();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}

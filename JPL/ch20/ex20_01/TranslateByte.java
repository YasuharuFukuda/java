package ch20.ex20_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class TranslateByte {

	public static void main(String[] args) {
		inputStreamtoOutputStream(System.in, System.out, (byte)args[0].charAt(0), (byte)args[1].charAt(0));
	}

	public static void inputStreamtoOutputStream(InputStream is, OutputStream os, byte from, byte to) {
		int _byte;
		try {
			while ((_byte = is.read()) != -1) {
				os.write(_byte == from ? to : _byte);
			}
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}

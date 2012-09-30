package ch20.ex20_03;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class EncryptOutputStream extends FilterOutputStream {
	private static byte key = 0x12;

	public EncryptOutputStream(OutputStream out) {
		super(out);
	}

	public void write(int data) throws IOException{
		int enccypted = data ^ key;
		super.write(enccypted);
	}

}

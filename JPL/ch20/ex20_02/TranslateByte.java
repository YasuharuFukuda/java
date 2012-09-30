package ch20.ex20_02;

import java.io.FilterReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;

public class TranslateByte extends FilterReader {

	public TranslateByte(Reader in) {
		super(in);
	}

	public int inputStreamtoOutputStream(char from, char to) throws IOException{
		int read = super.read();
		if(read == from)
			return (int)to;
		else
			return read;
	}
}

package ch20.ex20_03;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

public class DecryptInputStream extends FilterInputStream{
	private static byte key = 0x12;

	public DecryptInputStream(InputStream in) {
		super(in);
	}

	public int read() throws IOException{
        int in = super.read();
        if(in != -1){
            in = in ^ key;
        }
        return in;
	}

}

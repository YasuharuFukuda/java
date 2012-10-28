package ch23.ex23_02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MySystem {
	public static void main(String[] args) throws IOException{
		Runtime rt = Runtime.getRuntime();
		Process p = rt.exec("CMD.EXE /C DIR c:\\windows\\"); // ex. "CMD.EXE /C DIR c:\\windows\\"
		InputStream is = p.getInputStream();
		InputStreamReader isr = new InputStreamReader(is);
		BufferedReader br = new BufferedReader(isr);
		String result;
		int count = 1;
		while ((result = br.readLine()) != null) {
			System.out.println(count + ": " +result);
			count++;
		}
	}
}

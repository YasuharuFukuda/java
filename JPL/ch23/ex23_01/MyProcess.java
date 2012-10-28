package ch23.ex23_01;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class MyProcess {
	public static Process userProg(String cmd)
			throws IOException {
		Process proc = Runtime.getRuntime().exec(cmd);
		plugTogether(System.in, proc.getOutputStream());
		plugTogether(System.out, proc.getInputStream());
		plugTogether(System.err, proc.getErrorStream());
		return proc;
	}

	private static void plugTogether(final InputStream in, final OutputStream out) {
		new Thread() {
			public void run() {
				int ch;
				try {
					while ((ch = in.read()) != -1) {
						out.write(ch);
					}
				} catch (IOException e) {
				}
			}
		}.start();
	}

	private static void plugTogether(final OutputStream out, final InputStream in) {
		new Thread() {
			public void run() {
				int ch;
				try {
					while ((ch = in.read()) != -1) {
						out.write(ch);
					}
				} catch (IOException e) {
				}
			}
		}.start();
	}

}

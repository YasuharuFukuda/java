package ch20.ex20_08;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Entry {
	public static void main(String[] args) {
		Entry en = new Entry();
		en.createTable("JPL/ch20/ex20_08/test.txt");

		en.randomPrint("JPL/ch20/ex20_08/test.txt");
	}

	public void createTable(String filename) {
		RandomAccessFile rsf = null;
		File file = new File("JPL/ch20/ex20_08/out.txt");
		FileOutputStream fos = null;
		DataOutputStream out = null;

		try {
			fos = new FileOutputStream(file);
			rsf = new RandomAccessFile(filename, "rw");
			out = new DataOutputStream(fos);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		try {
			String line = null;
			while((line = rsf.readLine()) != null) {
				if(line.startsWith("%%")) {
					out.writeUTF(String.valueOf(rsf.getFilePointer()));
				}
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

	public void randomPrint(String filename) {
		RandomAccessFile rsf = null;
		File file = new File("JPL/ch20/ex20_08/out.txt");
		FileInputStream fis = null;
		DataInputStream in = null;
		long[] positions = new long[20];

		try {
			fis = new FileInputStream(file);
			rsf = new RandomAccessFile(filename, "rw");
			in = new DataInputStream(fis);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		try {
			String pos;
			int count = 0;
			try {
				while((pos = in.readUTF()) != null) {
					long l = Long.parseLong(pos);
					positions[count] = l;
					count++;
				}
			} catch (EOFException e) {
				// readUTFが上限にきた場合EOFException
			}
			int rnd = (int) (Math.random() * 10 + 1) / count;
			rsf.seek(positions[rnd]);
			System.out.println(rsf.readLine());
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

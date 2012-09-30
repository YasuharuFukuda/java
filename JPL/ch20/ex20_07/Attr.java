package ch20.ex20_07;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Attr {
	private final String name;
	private Object value = null;

	public Attr(String name) {
		this.name = name;
	}

	public Attr(String name, Object value) {
		this.name = name;
		this.value = value;
	}

	public Attr(DataInputStream in) throws IOException {
		name = in.readUTF();
		value = in.readUTF();
	}

	public String getName() {
		return name;
	}

	public Object getValue() {
		return value;
	}

	public Object setValue(Object newValue) {
		Object oldVal = value;
		value = newValue;
		return oldVal;
	}

	public String toString() {
		return name + "=" + value + "'";
	}

	public void writeData(DataOutputStream out) throws IOException{
		out.writeUTF(name);
		out.writeUTF(value.toString());
	}

	public static void main(String[] args) {
		 try {
			 File file = new File("JPL/ch20/ex20_07/out.txt");
			 FileOutputStream fos = new FileOutputStream(file);
			 DataOutputStream out = new DataOutputStream(fos);

			 Attr attr = new Attr("fuga","hoge");

			 attr.writeData(out);
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}


	}
}

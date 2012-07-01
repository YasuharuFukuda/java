package ch13.ex13_04;

import java.util.ArrayList;
import java.util.Iterator;

public class Test {
	public static ArrayList parseValue(String source) throws Exception {
		ArrayList list = new ArrayList();

		String[] lines = source.split("\n");

		for (String line : lines) {
			String[] typeAndValue = line.split(" ");

			if(typeAndValue[0].equals("Boolean"))
				list.add(Boolean.parseBoolean(typeAndValue[1]));
			else if(typeAndValue[0].equals("Byte"))
				list.add(Byte.parseByte(typeAndValue[1]));
			else if(typeAndValue[0].equals("Charactor"))
				list.add(typeAndValue[1].charAt(0));
			else if(typeAndValue[0].equals("Short"))
				list.add(Short.parseShort(typeAndValue[1]));
			else if(typeAndValue[0].equals("Integer"))
				list.add(Integer.parseInt(typeAndValue[1]));
			else if(typeAndValue[0].equals("Long"))
				list.add(Long.parseLong(typeAndValue[1]));
			else if(typeAndValue[0].equals("Float"))
				list.add(Float.parseFloat(typeAndValue[1]));
			else if(typeAndValue[0].equals("Double"))
				list.add(Double.parseDouble(typeAndValue[1]));
			else {
				throw new Exception();
			}
		}

		return list;
	}

	public static void main(String[] args) {
		ArrayList list = new ArrayList();
		try {
			list = Test.parseValue("Boolean true\nByte 3");
		} catch (Exception e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

		Iterator it = list.iterator();
        while (it.hasNext()) {
            System.out.println(it.next().toString());
        }
	}
}

package ch21.ex21_01;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileSort {
	public ArrayList<String> sortedList = new ArrayList<String>();

	public ArrayList<String> sortLine(String fileName) throws IOException{
		FileReader fr = null;
		try {
			fr = new FileReader(new File(fileName));
		} catch (FileNotFoundException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		BufferedReader br = new BufferedReader(fr);
		String line = null;
		while((line =br.readLine()) != null) {
			if (sortedList.size() == 0)
				sortedList.add(line);
			else {
				int count = 1;
				for (String list : sortedList) {
					if(line.compareTo(list) <= 0){
						sortedList.add(count - 1, line);
						break;
					} else if(count < sortedList.size()){
						count++;
					} else {
						sortedList.add(count, line);
						break;
					}
				}

			}
		}
		return sortedList;
	}

	public static void main(String[] args) {
		FileSort fs = new FileSort();
		try {
			ArrayList<String> data = fs.sortLine("JPL\\ch21\\ex21_01\\test.txt");
			for(String d : data) {
				System.out.println(d);
			}
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

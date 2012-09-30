package ch20.ex20_09;

import java.io.File;
import java.io.IOException;

public class FileInfo {

	public void printFileInfo(String... fileNames) throws IOException{
		for(String fileName : fileNames){
			File f = new File(fileName);
			System.out.println("==================" + fileName + "===================");
			System.out.println("name: " + f.getName());
			System.out.println("path: " + f.getPath());
			System.out.println("absolute patt: " + f.getAbsolutePath());
			System.out.println("canonical path: " + f.getCanonicalPath());
			System.out.println("parent: " + f.getParent());
			System.out.println("free space:" + f.getFreeSpace());
			System.out.println("total space:" + f.getTotalSpace());
			System.out.println("usable space:" + f.getUsableSpace());
			System.out.println("exists:" + f.exists());
			System.out.println("directory:" + f.isDirectory());
			System.out.println("file:" + f.isFile());
			System.out.println("last modified:" + f.lastModified());
			System.out.println("length:" + f.length());
			System.out.println("executable:" + f.canExecute());
			System.out.println("readable:" + f.canRead());
			System.out.println("writable:" + f.canWrite());
			System.out.println("hidden:" + f.isHidden());
		}
	}

	public static void main(String[] args) {
		FileInfo fi = new FileInfo();
		try {
			fi.printFileInfo("JPL/ch20/ex20_09/test.txt", "JPL/ch20/ex20_09/test2.txt");
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}

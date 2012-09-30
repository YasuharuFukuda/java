package ch20.ex20_11;

import java.io.File;
import java.io.FilenameFilter;

public class Find implements FilenameFilter{

	public boolean accept(File dir, String name) {
		return name.endsWith(prefix);
	}
	private File dir;
	private String prefix;

	public Find(File dir, String prefix) {
		this.dir = dir;
		this.prefix = prefix;
	}

	public String[] getList() {
		return dir.list(this);
	}

	public static void main(String[] args) {
		File f = new File("JPL\\ch20\\ex20_11");
		Find find = new Find(f, "txt");
		String[] lists = find.getList();

		for(String list : lists) {
			System.out.println(list);
		}
	}
}


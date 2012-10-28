package ch22.ex22_02;

import java.util.BitSet;
import java.util.HashMap;
import java.util.HashSet;
import java.util.TreeSet;

public class WhichChars {
	private HashSet<Character> used = new HashSet<Character>(); //なぜHaseSetなのでしょうか？
	public WhichChars(String str) {
		for(int i = 0; i < str.length(); i++)
			used.add(str.charAt(i));
	}

	public String toString(){
		TreeSet<Character > ts = new TreeSet(used);
		String desc = "[";

		for(Character c : ts){
			desc += c;
		}
		return desc + "]";
	}

	public static void main(String[] args) {
		WhichChars wc = new WhichChars("Testing 1 2 3");
		System.out.println(wc.toString());
	}

}

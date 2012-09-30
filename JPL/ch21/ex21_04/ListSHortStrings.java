package ch21.ex21_04;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;

public class ListSHortStrings extends ShortStrings implements java.util.ListIterator<String>{
	private String prevShort;
	private ListIterator<String> strings;

	public ListSHortStrings(Iterator<String> strings, int maxLen){
		super(strings, maxLen);
		prevShort = null;
	}

	public boolean hasPrevious() {
		if(prevShort != null)
			return true;
		while(strings.hasPrevious()) {
			prevShort = strings.previous();
			if(prevShort.length() <= maxLen)
				return true;
		}
		prevShort = null;
		return false;
	}

	public String previous() {
		if(prevShort == null && !hasPrevious())
			throw new NoSuchElementException();
		String n = prevShort;
		prevShort = null;
		return n;
	}

	public int nextIndex() {
		throw new UnsupportedOperationException();
	}

	public int previousIndex() {
		throw new UnsupportedOperationException();
	}

	public void set(String e) {
		throw new UnsupportedOperationException();
	}

	public void add(String e) {
		throw new UnsupportedOperationException();
	}


}

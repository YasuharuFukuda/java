package ch01.ex01_15;

public interface ExtLookup extends Lookup {
	void add(String name, Object object);
	void remove(String name);
}

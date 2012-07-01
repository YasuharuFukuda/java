package ch12.ex12_01;

public interface LinkedList<E> {
	String toString();
	Object getField();
	void setField(Object field);
	E getNextElement();
	void setNextElement(E nextElement);
	int size();
}

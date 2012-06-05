package ch04.ex04_03;

public interface LinkedList<E> {
	String toString();
	Object getField();
	void setField(Object field);
	E getNextElement();
	void setNextElement(E nextElement);
	int size();
}

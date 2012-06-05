package ch02.ex02_11;

public class LinkedList {
	private Object field;
	private LinkedList nextElement;

	public LinkedList(Object field) {
		this.field = field;
	}

	public String toString() {
		return "field: " + field.toString();
	}

}

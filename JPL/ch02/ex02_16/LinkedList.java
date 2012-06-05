package ch02.ex02_16;

public class LinkedList {
	private Object field;
	private LinkedList nextElement;

	public LinkedList(Object field) {
		this.field = field;
	}

	public String toString() {
		return "field: " + field.toString();
	}

	public Object getField(){
		return field;
	}

	public LinkedList getNextElement() {
		return nextElement;
	}

	public void setField(Object field) {
		this.field = field;
	}

	public void setNextElement(LinkedList nextElement) {
		this.nextElement = nextElement;
	}

	public int size() {
		if (nextElement == null) {
			return 1;
		} else {
			return 1 + nextElement.size();
		}
	}

}

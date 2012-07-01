package ch11.ex11_01;

import java.util.ArrayList;

public class LinkedList<E> implements Cloneable{
	private E field;
	private LinkedList nextElement;

	public LinkedList(E field) {
		this.field = field;
	}

	public String toString() {
		return "field: " + field.toString();
	}

	public E getField(){
		return field;
	}

	public LinkedList getNextElement() {
		return nextElement;
	}

	public void setField(E field) {
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

	public LinkedList clone() {
		try{
			LinkedList list = (LinkedList)super.clone();
			list.nextElement = (LinkedList)nextElement.clone();
			list.field = (E)field;
			return list;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}


}

package ch12.ex12_01;

import java.util.ArrayList;


public class LinkedListImpl implements Cloneable,LinkedList<LinkedList> {
	private Object field;
	private LinkedListImpl nextElement;

	public LinkedListImpl(Object field) {
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
		this.nextElement = (LinkedListImpl)nextElement;
	}

	public int size() {
		if (nextElement == null) {
			return 1;
		} else {
			return 1 + nextElement.size();
		}
	}

	public LinkedListImpl clone() {
		try{
			LinkedListImpl list = (LinkedListImpl)super.clone();
			list.nextElement = (LinkedListImpl)nextElement.clone();
			list.field = (Object)field;
			return list;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}

	public ArrayList<LinkedList> find(Object object) throws ObjectNotFoundException {
		ArrayList<LinkedList> list = new ArrayList<LinkedList>();
		LinkedList next = this;

		while(next != null) {
			if (next.getField().equals(object)) {
				list.add(next);
			}
			next = (LinkedList)next.getNextElement();
		}

		if (list.size() == 0)
			throw new ObjectNotFoundException();

		return list;

	}

}

package ex04_03;


public class LinkedListImpl implements Cloneable,LinkedList<LinkedListImpl> {
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

	public LinkedListImpl getNextElement() {
		return nextElement;
	}

	public void setField(Object field) {
		this.field = field;
	}

	public void setNextElement(LinkedListImpl nextElement) {
		this.nextElement = nextElement;
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

}

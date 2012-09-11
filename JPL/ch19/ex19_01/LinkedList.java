package ch19.ex19_01;

/**
 * An <code>LinkedList</code> object defines a list,
 * which has a field and a next element
 *
 * @version 1.0
 * @author fukuda
 *
 */
public class LinkedList {
	/** the field */
	private Object field;

	/** the next element */
	private LinkedList nextElement;

	/**
	 * Creates a new list node with the given field and an
	 * initial value of <code>null</code>
	 *
	 */
	public LinkedList(Object field) {
		this.field = field;
	}

	/**
	 * Returns this field info
	 */
	public String toString() {
		return "field: " + field.toString();
	}

	/**
	 * Returns this field
	 */
	public Object getField(){
		return field;
	}

	/**
	 * Returns next element
	 */
	public LinkedList getNextElement() {
		return nextElement;
	}

	/**
	 * Set Field
	 */
	public void setField(Object field) {
		this.field = field;
	}

	/**
	 * Set next element
	 */
	public void setNextElement(LinkedList nextElement) {
		this.nextElement = nextElement;
	}

	/**
	 * Return node size
	 */
	public int size() {
		if (nextElement == null) {
			return 1;
		} else {
			return 1 + nextElement.size();
		}
	}

}

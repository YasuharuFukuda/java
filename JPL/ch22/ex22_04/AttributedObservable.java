package ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Observable;

public class AttributedObservable extends Observable  implements Attributed, Iterable<Attr>{
	protected Map<String, Attr> attrTable =
			new HashMap<String, Attr>();

	public void add(Attr newAttr) {
		attrTable.put(newAttr.getName(), newAttr);
		setChanged();
		notifyObservers(newAttr);
	}

	public Attr find(String name) {
		return attrTable.get(name);
	}

	public Attr remove(String name) {
		Attr removed = attrTable.remove(name);
		setChanged();
		notifyObservers(removed);
		return removed;
	}

	public Iterator<Attr> attrs() {
		return attrTable.values().iterator();
	}

	public Iterator<Attr> iterator() {
		return attrs();
	}

	public int size() {
		return attrTable.size();
	}

}

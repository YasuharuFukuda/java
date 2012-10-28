package ch22.ex22_04;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class AttributedImpl implements Attributed, Iterable<Attr>{
	protected Map<String, Attr> attrTable =
			new HashMap<String, Attr>();

	public void add(Attr newAttr) {
		attrTable.put(newAttr.getName(), newAttr);
	}

	public Attr find(String name) {
		return attrTable.get(name);
	}

	public Attr remove(String name) {
		return attrTable.remove(name);
	}

	public Iterator<Attr> attrs() {
		return attrTable.values().iterator();
	}

	public Iterator<Attr> iterator() {
		return attrs();
	}

}

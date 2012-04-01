package ex01_15;

public class SimpleExtLookup implements ExtLookup {
	private String[] names;
	private Object[] values;

	public SimpleExtLookup() {
		names = new String[10];
		values = new Object[10];
	}

	public Object find(String name) {
		for (int i = 0; i < names.length; i++){
			if(names[i].equals(name))
				return values[i];
		}
		return null;
	}

	public void add(String name, Object object) {
		for (int i = 0; i < names.length; i++){
			if(name.equals(names[i])){
				values[i] = object;
				return;
			}
		}

		for (int i = 0; i < names.length; i++) {
			if (names[i] == null) {
				names[i] = name;
				values[i] = object;
			}
		}
	}

	public void remove(String name) {
		for (int i = 0; i < names.length; i++){
			if(names[i].equals(name))
				values[i] = null;
		}
	}


}

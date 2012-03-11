package ex01_15;

public class SimpleExtLookup implements ExtLookup {
	private String[] names;
	private Object[] values;

	public Object find(String name) {
		for (int i = 0; i < names.length; i++){
			if(names[i].equals(name))
				return values[i];
		}
		return null;
	}

	public void add(String name, Object object) {
		for (int i = 0; i < names.length; i++){
			if(names[i].equals(name)){
				values[i] = object;
				return;
			}
		}
		names[names.length + 1] = name;
		values[names.length + 1] = object;
	}

	public void remove(String name) {
		for (int i = 0; i < names.length; i++){
			if(names[i].equals(name))
				values[i] = null;
		}
	}

}

package ch03.ex03_07;

public class ColorAttr extends Attr {
	private ScreenColor myColor;

	public ColorAttr(String name, Object value) {
		super(name, value);
		decodeColor();
	}

	public ColorAttr(String name) {
		this(name, "transparent");
	}

	public ColorAttr(String name, ScreenColor value) {
		super(name, value.toString());
		myColor = value;
	}

	public Object setValue(Object newValue){
		Object retval = super.setValue(newValue);
		decodeColor();
		return retval;
	}

	public ScreenColor setValue(ScreenColor newValue) {
		super.setValue(newValue.toString());
		ScreenColor oldValue = myColor;
		myColor = newValue;
		return oldValue;
	}

	public ScreenColor getColor() {
		return myColor;
	}

	protected void decodeColor() {
		if(getValue() == null)
			myColor = null;
		else
			myColor = new ScreenColor();
	}

	public boolean equals(ColorAttr ca){
		if(this.getValue().equals(ca.getValue()) && this.getName().equals(ca.getName()))
			return true;
		else
			return false;
	}

	public int hashCode(){
		return getValue().hashCode();
	}

	public static void main(String[] args){
		ColorAttr ca = new ColorAttr("test","white");
		ColorAttr ca2 = new ColorAttr("test","white");
		System.out.println(ca.hashCode());
		System.out.println(ca2.hashCode());
		System.out.println(ca.equals(ca2));
	}
}

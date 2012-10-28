package ch22.ex22_04;

import java.util.Observable;
import java.util.Observer;

public class AttributedObserver implements Observer{
	AttributedObservable attr;
	private int prevSize;

	public AttributedObserver(AttributedObservable ao) {
		attr = ao;
		attr.addObserver(this);
	}

	public void update(Observable o, Object arg) {
		if (o != this.attr)
			throw new IllegalArgumentException();

		Attr attr = (Attr)arg;
		if (this.attr.size() > prevSize) {
			System.out.println("Attr " + attr + " is added.");
		} else if (this.attr.size() < prevSize) {
			System.out.println("Attr " + attr + " is removed.");
		}
		prevSize = this.attr.size();

	}
}

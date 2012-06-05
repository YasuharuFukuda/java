package ch03.ex03_07;

import static org.junit.Assert.*;

import org.junit.Test;

public class ColorAttrTest {

	@Test
	public void equalsTest1() {
		ColorAttr ca = new ColorAttr("test","white");
		ColorAttr ca2 = new ColorAttr("test","white");

		assertTrue(ca.equals(ca2));
	}

	@Test
	public void equalsTest2() {
		ColorAttr ca = new ColorAttr("test","white");
		ColorAttr ca2 = new ColorAttr("test","white2");

		assertFalse(ca.equals(ca2));
	}

	@Test
	public void equalsTest3() {
		ColorAttr ca = new ColorAttr("test","white");
		ColorAttr ca2 = new ColorAttr("test2","white");

		assertFalse(ca.equals(ca2));
	}

	@Test
	public void equalsTest4() {
		ColorAttr ca = new ColorAttr("test","white");
		ColorAttr ca2 = new ColorAttr("test2","white2");

		assertFalse(ca.equals(ca2));
	}
}

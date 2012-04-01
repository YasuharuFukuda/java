package ex01_15;

import static org.junit.Assert.*;

import org.junit.Test;

public class SimpleExtLookupTest {

	@Test
	public void addTest() {
		SimpleExtLookup sel = new SimpleExtLookup();

		sel.add("test", 0);

		assertEquals(sel.find("test"), 0);
	}

	public void removeTest() {
		SimpleExtLookup sel = new SimpleExtLookup();

		sel.add("test", 0);
		sel.remove("test");

		assertNull(sel.find("test"));

	}

}

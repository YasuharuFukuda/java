package ex02_11;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void toStringTest() {
		LinkedList first = new LinkedList("first");

		String expected = "field: " + "first";

		assertEquals(first.toString(), expected);
	}

}

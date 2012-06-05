package ch02.ex02_16;

import static org.junit.Assert.*;

import org.junit.Test;

public class LinkedListTest {

	@Test
	public void sizeTest() {
		LinkedList first = new LinkedList("first");
		LinkedList second = new LinkedList("second");
		first.setNextElement(second);

		assertEquals(first.size(), 2);
		assertEquals(second.size(), 1);

	}

}

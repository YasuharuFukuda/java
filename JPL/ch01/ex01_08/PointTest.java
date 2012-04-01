package ex01_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PointTest {

	@Test
	public void testSet() {
		Point p1 = new Point();
		p1.x = 1.0;
		p1.y = 1.0;

		Point p2 = new Point();
		p2.x = 2.0;
		p2.y = 2.0;

		p1.set(p2);

		assertEquals(p1.x, p2.x, 0.0);
		assertEquals(p1.y, p2.y, 0.0);

	}

}

package ch02.ex02_10;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void toStringTest() {
		Vehicle car = new Vehicle("yasuahru");
		car.speed = 50;
		car.angle = 0;

		String expected = "id: 0\n" + "owner: yasuahru\n" + "speed: " + 50 + "\n" + "angle: " + 0 + "\n";

		assertEquals(car.toString(), expected);

	}

}

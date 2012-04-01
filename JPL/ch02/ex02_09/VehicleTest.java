package ex02_09;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void getMaxIdTest() {

		// ID = 1
		Vehicle car = new Vehicle("yasuahru");
		car.speed = 50;
		car.angle = 0;

		// ID = 2
		Vehicle bike = new Vehicle("yasuharu");
		bike.speed = 30;
		bike.angle = 90;

		assertEquals(Vehicle.getMaxId(), 1);
	}

}

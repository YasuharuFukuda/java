package ch02.ex02_17;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	@Test
	public void turnTest1() {
		Vehicle car = new Vehicle("yasuahru");
		car.changeSpeed(50);
		car.setAngle(10);

		car.turn(30.0);

		assertEquals(car.getAngle(), 40.0, 0.0);

	}

	public void turnTest2() {
		Vehicle car = new Vehicle("yasuahru");
		car.changeSpeed(50);
		car.setAngle(10);

		car.turn(Vehicle.TURN_LEFT);
		assertEquals(car.getAngle(), 100.0, 0.0);

		car.turn(Vehicle.TURN_RIGHT);
		assertEquals(car.getAngle(), 10.0, 0.0);

		// TURN_LEFT, TURN_RIGHTに該当しないintの場合、angleは変更されない
		car.turn(10);
		assertEquals(car.getAngle(), 10.0, 0.0);


	}
}

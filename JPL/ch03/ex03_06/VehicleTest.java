package ch03.ex03_06;

import static org.junit.Assert.*;

import org.junit.Test;

public class VehicleTest {

	// gasがない場合startできない
	@Test
	public void startTestZeroGas() {
		Vehicle v1 = new Vehicle(0, 10);
		assertFalse(v1.start());
	}

	// batteryがない場合startできない
	@Test
	public void startTestzeroBattery() {
		Vehicle v1 = new Vehicle(10, 0);
		assertFalse(v1.start());
	}

	// 両方ある場合startできる
	@Test
	public void startTest() {
		Vehicle v1 = new Vehicle(10, 10);
		assertTrue(v1.start());
	}

}

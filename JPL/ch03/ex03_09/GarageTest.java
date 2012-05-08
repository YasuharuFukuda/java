package ex03_09;

import static org.junit.Assert.*;

import org.junit.Test;

public class GarageTest {

	@Test
	public void test() {
		Garage garage = new Garage();
		garage.addVehicle(new Vehicle("vehicle1"));
		garage.addVehicle(new Vehicle("vehicle2"));
		Garage cloneGarage = garage.clone();

		assertTrue(garage.toString().equals(cloneGarage.toString()));

		// cloneGarageにvehicleを追加するとtoStringの結果が異なること
		cloneGarage.addVehicle(new Vehicle("vehicle3"));
		assertFalse(garage.toString().equals(cloneGarage.toString()));
	}

}

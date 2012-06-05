package ch03.ex03_08;

import static org.junit.Assert.*;

import org.junit.Test;

public class PassengerVehicleTest {

	@Test
	public void test() {
		PassengerVehicle pv1 = new PassengerVehicle(10, 5);
		try {
			PassengerVehicle cpv1 = (PassengerVehicle)pv1.clone();

			// toStringの結果が等しいこと
			assertEquals(pv1.toString(), cpv1.toString());

			// cpv1を変更するとtoStringの結果が異なること
			cpv1.setSeats(20);
			assertFalse(pv1.toString().equals(cpv1.toString()));

		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}

}

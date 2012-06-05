package ch05.ex05_02;

import static org.junit.Assert.*;

import org.junit.Test;

public class BankAccountTest {

	@Test
	public void test() {
		BankAccount ba = new BankAccount();

		ba.deposit(1);
		ba.deposit(2);
		ba.deposit(3);
		ba.deposit(4);
		ba.deposit(5);
		ba.deposit(6);
		ba.deposit(7);
		ba.deposit(8);
		ba.deposit(9);
		ba.deposit(10);

		assertEquals(ba.history().next().toString(), "0: deposit 10");
		assertEquals(ba.history().next().toString(), "0: deposit 9");
		assertEquals(ba.history().next().toString(), "0: deposit 8");
		assertEquals(ba.history().next().toString(), "0: deposit 7");
		assertEquals(ba.history().next().toString(), "0: deposit 6");
		assertEquals(ba.history().next().toString(), "0: deposit 5");
		assertEquals(ba.history().next().toString(), "0: deposit 4");
		assertEquals(ba.history().next().toString(), "0: deposit 3");
		assertEquals(ba.history().next().toString(), "0: deposit 2");
		assertEquals(ba.history().next().toString(), "0: deposit 1");

	}


	@Test
	public void test2() {
		BankAccount ba = new BankAccount();

		ba.deposit(1);
		ba.deposit(2);
		ba.deposit(3);
		ba.deposit(4);
		ba.deposit(5);
		ba.deposit(6);
		ba.deposit(7);
		ba.deposit(8);
		ba.deposit(9);
		ba.deposit(10);
		ba.deposit(11);

		assertEquals(ba.history().next().toString(), "0: deposit 11");
		assertEquals(ba.history().next().toString(), "0: deposit 10");
		assertEquals(ba.history().next().toString(), "0: deposit 9");
		assertEquals(ba.history().next().toString(), "0: deposit 8");
		assertEquals(ba.history().next().toString(), "0: deposit 7");
		assertEquals(ba.history().next().toString(), "0: deposit 6");
		assertEquals(ba.history().next().toString(), "0: deposit 5");
		assertEquals(ba.history().next().toString(), "0: deposit 4");
		assertEquals(ba.history().next().toString(), "0: deposit 3");
		assertEquals(ba.history().next().toString(), "0: deposit 2");

		// 記録されるのは10個まで, deposit 1は記録されていない
		assertNull(ba.history().next());
 	}

}

package ex02_06;

import ex02_05.Vehicle;

public class LinkedList {
	private Object field;
	private LinkedList nextElement;

	public static void main(String[] args) {
		Vehicle car = new Vehicle();
		car.id = Vehicle.nextID++;
		car.speed = 50;
		car.angle = 0;
		car.owner = "yasuharu";

		Vehicle bike = new Vehicle();
		bike.id = Vehicle.nextID++;
		bike.speed = 30;
		bike.angle = 90;
		bike.owner = "yasuharu";

		LinkedList list = new LinkedList();
		list.field = car;
		LinkedList nextList = list.nextElement;
		
		nextList.field = bike;
		
	}
}

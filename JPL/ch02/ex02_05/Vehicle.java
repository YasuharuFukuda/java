package ch02.ex02_05;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	public static int nextID;
	public int id;

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

		System.out.println("car-owner: " + car.owner);
		System.out.println("car-speed: " + car.speed);
		System.out.println("car-angle: " + car.angle);

		System.out.println("bike-owner: " + bike.owner);
		System.out.println("bike-speed: " + bike.speed);
		System.out.println("bike-angle: " + bike.angle);
	}
}

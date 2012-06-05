package ch02.ex02_09;

public class Vehicle {
	public int speed;
	public int angle;
	public String owner;
	public static int nextID = 0;
	public int id;

	public Vehicle(){
		this.id = Vehicle.nextID++;
	}

	public Vehicle(String owner){
		this();
		this.owner = owner;
	}

	public static int getMaxId() {
		return nextID -1;
	}

	public static void main(String[] args) {
		Vehicle car = new Vehicle("yasuahru");
		car.speed = 50;
		car.angle = 0;

		Vehicle bike = new Vehicle("yasuharu");
		bike.speed = 30;
		bike.angle = 90;

		System.out.println("car-owner: " + car.owner);
		System.out.println("car-speed: " + car.speed);
		System.out.println("car-angle: " + car.angle);

		System.out.println("bike-owner: " + bike.owner);
		System.out.println("bike-speed: " + bike.speed);
		System.out.println("bike-angle: " + bike.angle);
	}

}

package ex02_15;

public class Vehicle {
	private int speed;
	private int angle;
	private String owner;
	private int id;

	private static int nextID;

	public Vehicle(){
		this.id = Vehicle.nextID++;
	}

	public Vehicle(String owner){
		this();
		this.owner = owner;
	}

	public static int getMaxId() {
		return nextID;
	}

	public String toString() {
		String desc = "";
		if (owner != null)
			desc += "owner: " + owner;
		desc += "speed: " + speed;
		desc += "angle: " + angle;

		return "id: " + id + desc;
	}

	public int getSpeed(){
		return speed;
	}

	public int getAngle(){
		return angle;
	}

	public int getId(){
		return id;
	}

	public String getOwner(){
		return owner;
	}

	public void changeSpeed(int speed) {
		this.speed = speed;
	}

	public void stop(){
		this.speed = 0;
	}

	public void setAngle(int angle) {
		this.angle = angle;

	}

	public void setOwner(String owner) {
		this.owner = owner;
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

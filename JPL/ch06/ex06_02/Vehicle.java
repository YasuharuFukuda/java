package ch06.ex06_02;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner;
	private int id;

	private static int nextID;

	public enum TURN {LEFT, RIGHT};

	//public static final int TURN_LEFT = 90;
	//public static final int TURN_RIGHT = -90;

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

	public double getSpeed(){
		return speed;
	}

	public double getAngle(){
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

	public double turn(double turnAngle) {
		this.angle = this.angle + turnAngle;
		return this.angle;
	}

	public double turn(TURN turnAngle) {
		if (turnAngle == TURN.LEFT) {
			return angle += 90;
		} else if (turnAngle == TURN.RIGHT) {
			return angle -= 90;
		}
		return angle;
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

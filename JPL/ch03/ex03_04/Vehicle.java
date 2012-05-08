package ex03_04;

public class Vehicle {
	private double speed;
	private double angle;
	private String owner;
	private int id;

	private static int nextID;

	private static final int TURN_LEFT = 90;
	private static final int TURN_RIGHT = -90;

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

	public double turn(int turn) {
		if (turn == Vehicle.TURN_LEFT) {
			return angle += Vehicle.TURN_LEFT;
		} else if (turn == Vehicle.TURN_RIGHT) {
			return angle += Vehicle.TURN_RIGHT;
		}
		return angle;
	}

	public static void main(String[] args) {
		Vehicle car = new Vehicle(args[0]);
		car.changeSpeed(50);
		car.setAngle(0);


		System.out.println("car-owner: " + car.getOwner());
		System.out.println("car-speed: " + car.getSpeed());
		System.out.println("car-angle: " + car.getAngle());
	}
}

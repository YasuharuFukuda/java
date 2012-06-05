package ch03.ex03_04;


public class PassengerVehicle extends Vehicle {
	private int seats;
	private int passenger;

	public PassengerVehicle() {
		super();
	}

	public PassengerVehicle(int seats, int passanger) {
		super();
		this.seats = seats;
		this.passenger = passanger;
	}


	public int getSeats(){
		return seats;
	}

	public int getPassanger() {
		return passenger;
	}

	public void setSeats(int seats) {
		this.seats = seats;
	}

	public void setPassenger(int passenger) {
		this.passenger = passenger;
	}

	public String toString() {
		return "seats: " + seats + "個, " +  "乗客: " + passenger + "人";
	}

	public static void main(String[] args) {
		PassengerVehicle pv1 = new PassengerVehicle(10, 5);
		PassengerVehicle pv2 = new PassengerVehicle(12, 5);

		System.out.println(pv1.toString());
		System.out.println(pv2.toString());
	}
}

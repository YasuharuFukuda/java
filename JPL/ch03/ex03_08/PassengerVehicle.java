package ch03.ex03_08;

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

		try {
			PassengerVehicle cpv1 = (PassengerVehicle)pv1.clone();
			System.out.println(pv1);
			System.out.println(cpv1);
			cpv1.setSeats(20);
			System.out.println(pv1);
			System.out.println(cpv1);
		} catch (CloneNotSupportedException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
	}
}
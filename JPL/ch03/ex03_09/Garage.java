package ch03.ex03_09;

import java.util.ArrayList;
import java.util.Iterator;

public class Garage implements Cloneable{
	private ArrayList vehicles = new ArrayList();

	public Garage(){
	}

	public void addVehicle(Vehicle vehicle) {
		vehicles.add(vehicle);
	}

	public Garage clone() {
		try{
			Garage grClone = (Garage)super.clone();
			grClone.vehicles = (ArrayList) vehicles.clone();
			return grClone;
		}catch(CloneNotSupportedException e){
			throw new InternalError(e.toString());
		}
	}

	public String toString(){
		String vehicleList = "";
		Iterator<Vehicle> it = vehicles.iterator();
		while(it.hasNext()){
			Vehicle vh = it.next();
			vehicleList += vh.toString() + "\n";
		}
		return vehicleList;
	}

	public static void main(String args[]){
		Garage garage = new Garage();
		garage.addVehicle(new Vehicle("vehicle1"));
		garage.addVehicle(new Vehicle("vehicle2"));
		Garage cloneGarage = garage.clone();
		cloneGarage.addVehicle(new Vehicle("vehicle3"));
		System.out.println(garage.toString());
		System.out.println(cloneGarage.toString());
	}

}

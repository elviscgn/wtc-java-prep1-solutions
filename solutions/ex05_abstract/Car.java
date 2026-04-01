package ex05_abstract;

public class Car extends Vehicle {

    public Car(String make, String model, int year, double fuelLevel) {
        super(make, model, year, fuelLevel);
    }

    public double calculateFuelEfficiency() {
        return 15;
    }
    public String getVehicleType() {
        return "Car";
    }
    public int getPassengerCapacity() {
        return 5;
    }
}

package ex05_abstract;

public class Motorcycle extends Vehicle {
    public Motorcycle(String make, String model, int year, double fl) {
        super(make, model, year, fl);
    }

    public double calculateFuelEfficiency() {
        return 25;
    }
    public String getVehicleType() {
        return "Car";
    }
    public int getPassengerCapacity() {
        return 2;
    }
}

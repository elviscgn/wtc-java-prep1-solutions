package ex05_abstract;

public class Truck extends Vehicle {
    private double cargoTons;

    public Truck(String make, String model, int year, double fl, double truckTons) {
        super(make, model, year, fl);
        this.cargoTons = truckTons;
    }

    public double calculateFuelEfficiency() {
        return 8;
    }
    public String getVehicleType() {
        return "Truck";
    }
    public int getPassengerCapacity() {
        return 3;
    }
}

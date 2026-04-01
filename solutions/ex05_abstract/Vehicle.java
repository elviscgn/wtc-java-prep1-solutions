package ex05_abstract;

public abstract class Vehicle {
    protected String make;
    protected String model;
    protected int year;
    protected double fuelLevel;

    public Vehicle(String make, String model, int year, double fuelLevel) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.fuelLevel = fuelLevel;
    }

    abstract double calculateFuelEfficiency();
    abstract String getVehicleType();
    abstract int getPassengerCapacity();

    public void refuel(double amount) {
        this.fuelLevel += amount;
    }

    public void displayInfo() {
        System.out.println("Make " + make + " Model: " + model);

    }

    public boolean isLowOnFuel() {
        if (fuelLevel < 20) {
            return true;
        }
        return false;
    }

    
}

import ex05_abstract.Vehicle;
import ex05_abstract.Car;
import ex05_abstract.Motorcycle;
import ex05_abstract.Truck;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;
import java.lang.reflect.Modifier;

@DisplayName("Exercise 5.1 — Vehicle Fleet")
class VehicleTest {

    // ── Abstract class check ──────────────────────────────────────────────────

    @Test @DisplayName("Vehicle is declared abstract")
    void vehicleIsAbstract() {
        assertTrue(Modifier.isAbstract(Vehicle.class.getModifiers()),
            "Vehicle must be declared abstract");
    }

    // ── Fuel efficiency ───────────────────────────────────────────────────────

    @Test @DisplayName("Car fuel efficiency is 15 km/L")
    void carEfficiency() {
        assertEquals(15.0, new Car("Toyota", "Corolla", 2020, 80.0).calculateFuelEfficiency(), 0.001);
    }

    @Test @DisplayName("Motorcycle fuel efficiency is 25 km/L")
    void motorcycleEfficiency() {
        assertEquals(25.0, new Motorcycle("Honda", "CBR", 2021, 60.0).calculateFuelEfficiency(), 0.001);
    }

    @Test @DisplayName("Truck fuel efficiency is 8 km/L")
    void truckEfficiency() {
        assertEquals(8.0, new Truck("Volvo", "FH16", 2019, 90.0, 20.0).calculateFuelEfficiency(), 0.001);
    }

    // ── Passenger capacity ────────────────────────────────────────────────────

    @Test @DisplayName("Car passenger capacity is 5")
    void carCapacity() {
        assertEquals(5, new Car("Toyota", "Corolla", 2020, 80.0).getPassengerCapacity());
    }

    @Test @DisplayName("Motorcycle passenger capacity is 2")
    void motorcycleCapacity() {
        assertEquals(2, new Motorcycle("Honda", "CBR", 2021, 60.0).getPassengerCapacity());
    }

    @Test @DisplayName("Truck passenger capacity is 3")
    void truckCapacity() {
        assertEquals(3, new Truck("Volvo", "FH16", 2019, 90.0, 20.0).getPassengerCapacity());
    }

    // ── isLowOnFuel ───────────────────────────────────────────────────────────

    @Test @DisplayName("isLowOnFuel() true when fuelLevel < 20")
    void isLowOnFuelTrue() {
        assertTrue(new Car("Toyota", "Corolla", 2020, 15.0).isLowOnFuel());
    }

    @Test @DisplayName("isLowOnFuel() false at boundary value of 20")
    void isLowOnFuelBoundary() {
        assertFalse(new Car("Toyota", "Corolla", 2020, 20.0).isLowOnFuel());
    }

    @Test @DisplayName("isLowOnFuel() false when fuelLevel > 20")
    void isLowOnFuelFalse() {
        assertFalse(new Motorcycle("Honda", "CBR", 2021, 60.0).isLowOnFuel());
    }

    // ── Inheritance ───────────────────────────────────────────────────────────

    @Test @DisplayName("All vehicle types are instances of Vehicle")
    void allAreVehicles() {
        assertInstanceOf(Vehicle.class, new Car("Toyota", "Corolla", 2020, 80.0));
        assertInstanceOf(Vehicle.class, new Motorcycle("Honda", "CBR", 2021, 60.0));
        assertInstanceOf(Vehicle.class, new Truck("Volvo", "FH16", 2019, 90.0, 20.0));
    }

    @Test @DisplayName("getVehicleType() returns non-blank string for each subclass")
    void vehicleTypeNonBlank() {
        assertFalse(new Car("Toyota", "Corolla", 2020, 80.0).getVehicleType().isBlank());
        assertFalse(new Motorcycle("Honda", "CBR", 2021, 60.0).getVehicleType().isBlank());
        assertFalse(new Truck("Volvo", "FH16", 2019, 90.0, 20.0).getVehicleType().isBlank());
    }
}

import ex01_syntax.TemperatureConverter;
import org.junit.jupiter.api.*;
import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Exercise 1.1 — TemperatureConverter")
class TemperatureConverterTest {

    private static final double D = 0.01;

    @Test @DisplayName("celsiusToFahrenheit(100) = 212")
    void boilingPoint() {
        assertEquals(212.0, TemperatureConverter.celsiusToFahrenheit(100.0), D);
    }

    @Test @DisplayName("celsiusToFahrenheit(0) = 32")
    void freezingPoint() {
        assertEquals(32.0, TemperatureConverter.celsiusToFahrenheit(0.0), D);
    }

    @Test @DisplayName("celsiusToFahrenheit(-40) = -40 (crossover point)")
    void crossoverPoint() {
        assertEquals(-40.0, TemperatureConverter.celsiusToFahrenheit(-40.0), D);
    }

    @Test @DisplayName("celsiusToFahrenheit(37) ≈ 98.6 (body temp)")
    void bodyTemp() {
        assertEquals(98.6, TemperatureConverter.celsiusToFahrenheit(37.0), D);
    }

    @Test @DisplayName("fahrenheitToCelsius(212) = 100")
    void fahrenheitBoiling() {
        assertEquals(100.0, TemperatureConverter.fahrenheitToCelsius(212.0), D);
    }

    @Test @DisplayName("fahrenheitToCelsius(32) = 0")
    void fahrenheitFreezing() {
        assertEquals(0.0, TemperatureConverter.fahrenheitToCelsius(32.0), D);
    }

    @Test @DisplayName("fahrenheitToCelsius(-40) = -40")
    void fahrenheitCrossover() {
        assertEquals(-40.0, TemperatureConverter.fahrenheitToCelsius(-40.0), D);
    }

    @Test @DisplayName("celsiusToKelvin(0) = 273.15")
    void kelvinFreezing() {
        assertEquals(273.15, TemperatureConverter.celsiusToKelvin(0.0), D);
    }

    @Test @DisplayName("celsiusToKelvin(100) = 373.15")
    void kelvinBoiling() {
        assertEquals(373.15, TemperatureConverter.celsiusToKelvin(100.0), D);
    }

    @Test @DisplayName("celsiusToKelvin(-273.15) = 0 (absolute zero)")
    void absoluteZero() {
        assertEquals(0.0, TemperatureConverter.celsiusToKelvin(-273.15), D);
    }

    @Test @DisplayName("C→F→C round trip returns original value")
    void roundTrip() {
        double original = 36.6;
        double result = TemperatureConverter.fahrenheitToCelsius(
                        TemperatureConverter.celsiusToFahrenheit(original));
        assertEquals(original, result, D);
    }
}

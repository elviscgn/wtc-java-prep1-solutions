package ex01_syntax;

public class TemperatureConverter {
    public static double celsiusToFahrenheit(double c) {
        return (c * 9/5) + 32;
    }
    public static double fahrenheitToCelsius(double f) {
        return (f - 32) * 5/9;
    }
    public static double celsiusToKelvin(double c) {
        return c + 273.15;
    }
}

package br.com.carlosrocha.converters;

public class TemperatureConverter {

    public static double celsiusToFahrenheit(double celsius) {
        return (celsius * 9/5) + 32;
    }

    public static double fahrenheitToCelsius(double fahrenheit) {
        return (fahrenheit - 32) * 5/9;
    }

    public static double convert(String fromUnit, String toUnit, double value) {
        if ("Celsius".equalsIgnoreCase(fromUnit) && "Fahrenheit".equalsIgnoreCase(toUnit)) {
            return celsiusToFahrenheit(value);
        } else if ("Fahrenheit".equalsIgnoreCase(fromUnit) && "Celsius".equalsIgnoreCase(toUnit)) {
            return fahrenheitToCelsius(value);
        } else {
            throw new IllegalArgumentException("Unidades de conversão desconhecidas.");
        }
    }
}

package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void main(String[] args) {

        // ✅ Temperature Equality
        Quantity<TemperatureUnit> t1 =
                new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> t2 =
                new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C == 32°F → " + t1.equals(t2));

        // ✅ Conversion
        Quantity<TemperatureUnit> converted =
                t1.convertTo(TemperatureUnit.FAHRENHEIT);

        System.out.println("0°C to F → " + converted);

        // ❌ Unsupported Operation
        try {
            t1.add(new Quantity<>(10, TemperatureUnit.CELSIUS));
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
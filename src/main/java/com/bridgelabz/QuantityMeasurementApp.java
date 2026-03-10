package com.bridgelabz;

public class QuantityMeasurementApp {

    // Demonstrate conversion using raw value
    public static double demonstrateLengthConversion(
            double value,
            Length.LengthUnit fromUnit,
            Length.LengthUnit toUnit) {

        double result = Length.convert(value, fromUnit, toUnit);

        System.out.println(
                "Input: convert(" + value + ", " + fromUnit + ", " + toUnit + ") → Output: " + result
        );

        return result;
    }

    // Method overloading example
    public static Length demonstrateLengthConversion(
            Length length,
            Length.LengthUnit targetUnit) {

        Length result = length.convertTo(targetUnit);

        System.out.println(
                "Input: " + length + " → Output: " + result
        );

        return result;
    }

    // Equality demonstration
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {

        boolean result = l1.equals(l2);

        System.out.println(
                "Input: " + l1 + " and " + l2 + " → Equal (" + result + ")"
        );

        return result;
    }

    public static void main(String[] args) {

        demonstrateLengthConversion(1.0,
                Length.LengthUnit.FEET,
                Length.LengthUnit.INCHES);

        demonstrateLengthConversion(3.0,
                Length.LengthUnit.YARDS,
                Length.LengthUnit.FEET);

        demonstrateLengthConversion(36.0,
                Length.LengthUnit.INCHES,
                Length.LengthUnit.YARDS);

        demonstrateLengthConversion(1.0,
                Length.LengthUnit.CENTIMETERS,
                Length.LengthUnit.INCHES);

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        demonstrateLengthConversion(yard, Length.LengthUnit.INCHES);
    }
}
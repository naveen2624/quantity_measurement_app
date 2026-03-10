package com.bridgelabz;

public class QuantityMeasurementApp {

    public static void demonstrateAddition(
            Length l1,
            Length l2,
            Length.LengthUnit targetUnit) {

        Length result = l1.add(l2, targetUnit);

        System.out.println(
                "Input: add(" + l1 + ", " + l2 + ", " + targetUnit + ")"
        );

        System.out.println(
                "Output: " + result
        );
    }

    public static void main(String[] args) {

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.FEET
        );

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.INCHES
        );

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.YARDS
        );

        demonstrateAddition(
                new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS),
                Length.LengthUnit.FEET
        );

        demonstrateAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES),
                Length.LengthUnit.CENTIMETERS
        );
    }
}
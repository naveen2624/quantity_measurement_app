package com.bridgelabz;

public class QuantityMeasurementApp {

    public static Length demonstrateAddition(Length l1, Length l2) {

        Length result = l1.add(l2);

        System.out.println(
                "Input: add(" + l1 + ", " + l2 + ")"
        );

        System.out.println(
                "Output: " + result
        );

        return result;
    }

    public static void main(String[] args) {

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(2.0, Length.LengthUnit.FEET)
        );

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.FEET),
                new Length(12.0, Length.LengthUnit.INCHES)
        );

        demonstrateAddition(
                new Length(12.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.FEET)
        );

        demonstrateAddition(
                new Length(1.0, Length.LengthUnit.YARDS),
                new Length(3.0, Length.LengthUnit.FEET)
        );

        demonstrateAddition(
                new Length(36.0, Length.LengthUnit.INCHES),
                new Length(1.0, Length.LengthUnit.YARDS)
        );

        demonstrateAddition(
                new Length(2.54, Length.LengthUnit.CENTIMETERS),
                new Length(1.0, Length.LengthUnit.INCHES)
        );
    }
}
package com.bridgelabz;

public class QuantityMeasurementApp {

    // Generic equality method
    public static boolean demonstrateLengthEquality(Length length1, Length length2) {
        return length1.equals(length2);
    }

    // Feet equality
    public static void demonstrateFeetEquality() {

        Length feet1 = new Length(1.0, Length.LengthUnit.FEET);
        Length feet2 = new Length(1.0, Length.LengthUnit.FEET);

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(feet1, feet2) + ")");
    }

    // Inches equality
    public static void demonstrateInchesEquality() {

        Length inch1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length inch2 = new Length(1.0, Length.LengthUnit.INCHES);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(inch1, inch2) + ")");
    }

    // Feet vs Inches comparison
    public static void demonstrateFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        System.out.println("Input: 1.0 ft and 12.0 inch");
        System.out.println("Output: Equal (" + demonstrateLengthEquality(feet, inches) + ")");
    }

    // Main method
    public static void main(String[] args) {

        demonstrateFeetEquality();
        demonstrateInchesEquality();
        demonstrateFeetInchesComparison();
    }
}
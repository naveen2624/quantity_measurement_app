package com.bridgelabz;

public class QuantityMeasurementApp {

    // Generic equality checker
    public static boolean demonstrateLengthEquality(Length l1, Length l2) {
        return l1.equals(l2);
    }

    // Generic demonstration method
    public static boolean demonstrateLengthComparison(
            double value1, Length.LengthUnit unit1,
            double value2, Length.LengthUnit unit2) {

        Length length1 = new Length(value1, unit1);
        Length length2 = new Length(value2, unit2);

        boolean result = length1.equals(length2);

        System.out.println("Input: Quantity(" + value1 + ", " + unit1 +
                ") and Quantity(" + value2 + ", " + unit2 + ")");
        System.out.println("Output: Equal (" + result + ")");
        System.out.println();

        return result;
    }

    public static void main(String[] args) {

        // Feet vs Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.FEET,
                12.0, Length.LengthUnit.INCHES);

        // Yard vs Feet
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                3.0, Length.LengthUnit.FEET);

        // Yard vs Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.YARDS,
                36.0, Length.LengthUnit.INCHES);

        // Centimeters vs Inches
        demonstrateLengthComparison(1.0, Length.LengthUnit.CENTIMETERS,
                0.393701, Length.LengthUnit.INCHES);

        // Centimeters vs Feet
        demonstrateLengthComparison(30.48, Length.LengthUnit.CENTIMETERS,
                1.0, Length.LengthUnit.FEET);
    }
}
package com.bridgelabz;

import java.util.Objects;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for units and conversion factors (base unit = inches)
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0);

        private final double conversionFactor;

        LengthUnit(double conversionFactor) {
            this.conversionFactor = conversionFactor;
        }

        public double getConversionFactor() {
            return conversionFactor;
        }
    }

    // Constructor
    public Length(double value, LengthUnit unit) {

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    // Convert value to base unit (inches)
    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // Compare two Length objects
    public boolean compare(Length otherLength) {

        if (otherLength == null)
            return false;

        return Double.compare(
                this.convertToBaseUnit(),
                otherLength.convertToBaseUnit()
        ) == 0;
    }

    // Override equals method
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return compare(other);
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }
}
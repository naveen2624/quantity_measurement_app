package com.bridgelabz;
import java.util.Objects;

public class Length {

    // Instance variables
    private double value;
    private LengthUnit unit;

    // Enum for supported units
    // Base unit = INCHES
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

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

    // Convert to base unit (inches)
    private double convertToBaseUnit() {

        double result = value * unit.getConversionFactor();

        // rounding improves precision stability
        return Math.round(result * 100000.0) / 100000.0;
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

    // equals override
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

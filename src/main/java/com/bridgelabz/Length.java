package com.bridgelabz;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Enum for supported units (base unit = inches)
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

    public Length(double value, LengthUnit unit) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public LengthUnit getUnit() {
        return unit;
    }

    // -------- STATIC CONVERSION API (UC5) --------

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double baseValue = value * source.getConversionFactor();

        double result = baseValue / target.getConversionFactor();

        return round(result);
    }

    // -------- INSTANCE CONVERSION --------

    public Length convertTo(LengthUnit targetUnit) {

        double convertedValue = convert(this.value, this.unit, targetUnit);

        return new Length(convertedValue, targetUnit);
    }

    // -------- BASE UNIT CONVERSION --------

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // -------- ROUNDING --------

    private static double round(double value) {
        return Math.round(value * 100000.0) / 100000.0;
    }

    // -------- EQUALS OVERRIDE --------

    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Double.compare(
                this.convertToBaseUnit(),
                other.convertToBaseUnit()
        ) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(convertToBaseUnit());
    }

    // -------- toString() --------

    @Override
    public String toString() {
        return value + " " + unit;
    }
}
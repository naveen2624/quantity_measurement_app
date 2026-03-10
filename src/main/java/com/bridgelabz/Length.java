package com.bridgelabz;

import java.util.Objects;

public class Length {

    private final double value;
    private final LengthUnit unit;

    // Base unit = INCHES
    public enum LengthUnit {

        FEET(12.0),
        INCHES(1.0),
        YARDS(36.0),
        CENTIMETERS(0.393701);

        private final double conversionFactor;

        LengthUnit(double factor) {
            this.conversionFactor = factor;
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

    // ---------------- CONVERSION ----------------

    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double baseValue = value * source.getConversionFactor();
        double result = baseValue / target.getConversionFactor();

        return result;
    }

    public Length convertTo(LengthUnit targetUnit) {
        double newValue = convert(this.value, this.unit, targetUnit);
        return new Length(newValue, targetUnit);
    }

    // ---------------- ADDITION ----------------

    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        // convert both to base unit
        double base1 = this.value * this.unit.getConversionFactor();
        double base2 = other.value * other.unit.getConversionFactor();

        double sumBase = base1 + base2;

        // convert back to unit of first operand
        double resultValue = sumBase / this.unit.getConversionFactor();

        return new Length(resultValue, this.unit);
    }

    // Static overloaded addition
    public static Length add(Length l1, Length l2) {

        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Operands cannot be null");

        return l1.add(l2);
    }

    // ---------------- EQUALITY ----------------

    private double convertToBaseUnit() {
        return value * unit.getConversionFactor();
    }

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

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
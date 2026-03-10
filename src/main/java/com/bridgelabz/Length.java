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

    // -------- Convert to Base Unit --------
    private double toBaseUnit() {
        return value * unit.getConversionFactor();
    }

    // -------- Static Conversion API (UC5) --------
    public static double convert(double value, LengthUnit source, LengthUnit target) {

        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid numeric value");

        if (source == null || target == null)
            throw new IllegalArgumentException("Unit cannot be null");

        double baseValue = value * source.getConversionFactor();
        return baseValue / target.getConversionFactor();
    }

    public Length convertTo(LengthUnit targetUnit) {

        double converted = convert(this.value, this.unit, targetUnit);

        return new Length(converted, targetUnit);
    }

    // -------- UC6 Addition (Result in first operand unit) --------
    public Length add(Length other) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();

        double result = sumBase / this.unit.getConversionFactor();

        return new Length(result, this.unit);
    }

    // -------- UC7 Addition (Explicit Target Unit) --------
    public Length add(Length other, LengthUnit targetUnit) {

        if (other == null)
            throw new IllegalArgumentException("Second operand cannot be null");

        if (targetUnit == null)
            throw new IllegalArgumentException("Target unit cannot be null");

        double sumBase = this.toBaseUnit() + other.toBaseUnit();

        double result = sumBase / targetUnit.getConversionFactor();

        return new Length(result, targetUnit);
    }

    // Static overloaded method
    public static Length add(Length l1, Length l2, LengthUnit targetUnit) {

        if (l1 == null || l2 == null)
            throw new IllegalArgumentException("Operands cannot be null");

        return l1.add(l2, targetUnit);
    }

    // -------- Equality --------
    @Override
    public boolean equals(Object obj) {

        if (this == obj)
            return true;

        if (obj == null || getClass() != obj.getClass())
            return false;

        Length other = (Length) obj;

        return Double.compare(this.toBaseUnit(), other.toBaseUnit()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBaseUnit());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}
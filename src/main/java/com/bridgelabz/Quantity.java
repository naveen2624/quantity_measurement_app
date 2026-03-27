package com.bridgelabz;

import java.util.Objects;

public class Quantity<U extends IMeasurable> {

    private final double value;
    private final U unit;

    public Quantity(double value, U unit) {
        if (!Double.isFinite(value))
            throw new IllegalArgumentException("Invalid value");

        if (unit == null)
            throw new IllegalArgumentException("Unit cannot be null");

        this.value = value;
        this.unit = unit;
    }

    public double getValue() {
        return value;
    }

    public U getUnit() {
        return unit;
    }

    // Convert to base
    private double toBase() {
        return unit.toBaseUnit(value);
    }

    // Convert to another unit
    public Quantity<U> convertTo(U targetUnit) {
        double base = this.toBase();
        double converted = targetUnit.fromBaseUnit(base);
        return new Quantity<>(converted, targetUnit);
    }

    // ADD
    public Quantity<U> add(Quantity<U> other) {

        unit.validateOperationSupport("addition");

        double resultBase = this.toBase() + other.toBase();
        double result = unit.fromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }

    // SUBTRACT
    public Quantity<U> subtract(Quantity<U> other) {

        unit.validateOperationSupport("subtraction");

        double resultBase = this.toBase() - other.toBase();
        double result = unit.fromBaseUnit(resultBase);

        return new Quantity<>(result, unit);
    }

    // DIVIDE
    public double divide(Quantity<U> other) {

        unit.validateOperationSupport("division");

        return this.toBase() / other.toBase();
    }

    // EQUALS
    @Override
    public boolean equals(Object obj) {

        if (this == obj) return true;

        if (!(obj instanceof Quantity<?> other))
            return false;

        // prevent cross-category comparison
        if (!this.unit.getClass().equals(other.unit.getClass()))
            return false;

        return Double.compare(this.toBase(), other.toBase()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toBase());
    }

    @Override
    public String toString() {
        return "Quantity(" + value + ", " + unit + ")";
    }
}

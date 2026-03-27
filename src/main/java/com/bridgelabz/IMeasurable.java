package com.bridgelabz;

public interface IMeasurable {

    double toBaseUnit(double value);

    double fromBaseUnit(double baseValue);

    // Functional Interface support
    @FunctionalInterface
    interface SupportsArithmetic {
        boolean isSupported();
    }

    // Default: all units support arithmetic
    SupportsArithmetic supportsArithmetic = () -> true;

    default boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    // Default validation (can be overridden)
    default void validateOperationSupport(String operation) {
        // By default, do nothing
    }
}
package com.bridgelabz;

public enum TemperatureUnit implements IMeasurable {

    CELSIUS {
        public double toBaseUnit(double value) {
            return value; // base = Celsius
        }

        public double fromBaseUnit(double baseValue) {
            return baseValue;
        }
    },

    FAHRENHEIT {
        public double toBaseUnit(double value) {
            return (value - 32) * 5 / 9;
        }

        public double fromBaseUnit(double baseValue) {
            return (baseValue * 9 / 5) + 32;
        }
    };

    // ❌ Temperature does NOT support arithmetic
    SupportsArithmetic supportsArithmetic = () -> false;

    @Override
    public boolean supportsArithmetic() {
        return supportsArithmetic.isSupported();
    }

    @Override
    public void validateOperationSupport(String operation) {
        throw new UnsupportedOperationException(
                "Temperature does not support " + operation + " operation"
        );
    }
}
package com.bridgelabz;

import java.util.Objects;

public class QuantityMeasurementApp {

    // ================= FEET CLASS =================
    public static class Feet {

        private final double value;

        public Feet(double value) {
            this.value = value;
        }

        public double toInches() {
            return value * 12;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;

            if (obj instanceof Feet) {
                Feet other = (Feet) obj;
                return Double.compare(this.value, other.value) == 0;
            }

            if (obj instanceof Inches) {
                Inches other = (Inches) obj;
                return Double.compare(this.toInches(), other.value) == 0;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    // ================= INCH CLASS =================
    public static class Inches {

        private final double value;

        public Inches(double value) {
            this.value = value;
        }

        public double toFeet() {
            return value / 12;
        }

        @Override
        public boolean equals(Object obj) {

            if (this == obj) return true;
            if (obj == null) return false;

            if (obj instanceof Inches) {
                Inches other = (Inches) obj;
                return Double.compare(this.value, other.value) == 0;
            }

            if (obj instanceof Feet) {
                Feet other = (Feet) obj;
                return Double.compare(this.value, other.toInches()) == 0;
            }

            return false;
        }

        @Override
        public int hashCode() {
            return Objects.hash(value);
        }
    }

    // ================= STATIC METHODS =================

    public static boolean compareFeet(double value1, double value2) {
        Feet feet1 = new Feet(value1);
        Feet feet2 = new Feet(value2);
        return feet1.equals(feet2);
    }

    public static boolean compareInches(double value1, double value2) {
        Inches inch1 = new Inches(value1);
        Inches inch2 = new Inches(value2);
        return inch1.equals(inch2);
    }

    public static boolean compareFeetAndInches(double feetValue, double inchValue) {
        Feet feet = new Feet(feetValue);
        Inches inches = new Inches(inchValue);
        return feet.equals(inches);
    }

    // ================= MAIN METHOD =================

    public static void main(String[] args) {

        boolean inchResult = compareInches(1.0, 1.0);
        boolean feetResult = compareFeet(1.0, 1.0);
        boolean crossResult = compareFeetAndInches(1.0, 12.0);

        System.out.println("Input: 1.0 inch and 1.0 inch");
        System.out.println("Output: Equal (" + inchResult + ")");

        System.out.println("Input: 1.0 ft and 1.0 ft");
        System.out.println("Output: Equal (" + feetResult + ")");

        System.out.println("Input: 1.0 ft and 12.0 inch");
        System.out.println("Output: Equal (" + crossResult + ")");
    }
}
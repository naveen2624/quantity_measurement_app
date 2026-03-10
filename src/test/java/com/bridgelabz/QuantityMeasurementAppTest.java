package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testConversion_FeetToInches() {
        assertEquals(12.0,
                Length.convert(1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                EPS);
    }

    @Test
    void testConversion_InchesToFeet() {
        assertEquals(2.0,
                Length.convert(24.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.FEET),
                EPS);
    }

    @Test
    void testConversion_YardsToInches() {
        assertEquals(36.0,
                Length.convert(1.0,
                        Length.LengthUnit.YARDS,
                        Length.LengthUnit.INCHES),
                EPS);
    }

    @Test
    void testConversion_InchesToYards() {
        assertEquals(2.0,
                Length.convert(72.0,
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.YARDS),
                EPS);
    }

    @Test
    void testConversion_CentimetersToInches() {
        assertEquals(1.0,
                Length.convert(2.54,
                        Length.LengthUnit.CENTIMETERS,
                        Length.LengthUnit.INCHES),
                1e-3);
    }

    @Test
    void testConversion_ZeroValue() {
        assertEquals(0.0,
                Length.convert(0.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                EPS);
    }

    @Test
    void testConversion_NegativeValue() {
        assertEquals(-12.0,
                Length.convert(-1.0,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES),
                EPS);
    }

    @Test
    void testConversion_RoundTrip_PreservesValue() {

        double value = 5.0;

        double converted =
                Length.convert(
                        Length.convert(value,
                                Length.LengthUnit.FEET,
                                Length.LengthUnit.INCHES),
                        Length.LengthUnit.INCHES,
                        Length.LengthUnit.FEET);

        assertEquals(value, converted, EPS);
    }

    @Test
    void testConversion_InvalidUnit_Throws() {

        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(1.0, null, Length.LengthUnit.FEET));
    }

    @Test
    void testConversion_NaNOrInfinite_Throws() {

        assertThrows(IllegalArgumentException.class,
                () -> Length.convert(Double.NaN,
                        Length.LengthUnit.FEET,
                        Length.LengthUnit.INCHES));
    }
}
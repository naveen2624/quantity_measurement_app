package com.bridgelabz;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-6;

    @Test
    void testAddition_SameUnit_FeetPlusFeet() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(2.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(3.0, result.getValue(), EPS);
        assertEquals(Length.LengthUnit.FEET, result.getUnit());
    }

    @Test
    void testAddition_SameUnit_InchPlusInch() {

        Length l1 = new Length(6.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(6.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(12.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_CrossUnit_FeetPlusInches() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(12.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(2.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_CrossUnit_InchPlusFeet() {

        Length l1 = new Length(12.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(24.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_WithZero() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(0.0, Length.LengthUnit.INCHES);

        Length result = l1.add(l2);

        assertEquals(5.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_NegativeValues() {

        Length l1 = new Length(5.0, Length.LengthUnit.FEET);
        Length l2 = new Length(-2.0, Length.LengthUnit.FEET);

        Length result = l1.add(l2);

        assertEquals(3.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_NullSecondOperand() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);

        assertThrows(IllegalArgumentException.class,
                () -> l1.add(null));
    }
}
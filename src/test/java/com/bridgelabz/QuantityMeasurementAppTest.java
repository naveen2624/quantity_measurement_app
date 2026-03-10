package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityMeasurementAppTest {

    private static final double EPS = 1e-3;

    @Test
    void testAddition_TargetUnit_Feet() {

        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(12, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.FEET);

        assertEquals(2.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_TargetUnit_Inches() {

        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(12, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.INCHES);

        assertEquals(24.0, result.getValue(), EPS);
    }

    @Test
    void testAddition_TargetUnit_Yards() {

        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(12, Length.LengthUnit.INCHES);

        Length result = l1.add(l2, Length.LengthUnit.YARDS);

        assertEquals(0.667, result.getValue(), EPS);
    }

    @Test
    void testAddition_Commutativity() {

        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(12, Length.LengthUnit.INCHES);

        Length r1 = l1.add(l2, Length.LengthUnit.YARDS);
        Length r2 = l2.add(l1, Length.LengthUnit.YARDS);

        assertEquals(r1.getValue(), r2.getValue(), EPS);
    }

    @Test
    void testAddition_NullTargetUnit() {

        Length l1 = new Length(1, Length.LengthUnit.FEET);
        Length l2 = new Length(12, Length.LengthUnit.INCHES);

        assertThrows(IllegalArgumentException.class,
                () -> l1.add(l2, null));
    }
}
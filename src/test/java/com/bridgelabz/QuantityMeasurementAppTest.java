package com.bridgelabz;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class QuantityMeasurementAppTest {

    @Test
    public void testFeetEquality() {

        Length l1 = new Length(1.0, Length.LengthUnit.FEET);
        Length l2 = new Length(1.0, Length.LengthUnit.FEET);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testInchesEquality() {

        Length l1 = new Length(1.0, Length.LengthUnit.INCHES);
        Length l2 = new Length(1.0, Length.LengthUnit.INCHES);

        assertTrue(l1.equals(l2));
    }

    @Test
    public void testFeetInchesComparison() {

        Length feet = new Length(1.0, Length.LengthUnit.FEET);
        Length inches = new Length(12.0, Length.LengthUnit.INCHES);

        assertTrue(feet.equals(inches));
    }

    @Test
    public void yardEquals3Feet() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);

        assertTrue(yard.equals(feet));
    }

    @Test
    public void yardEquals36Inches() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(inches));
    }

    @Test
    public void centimeterEqualsInch() {

        Length cm = new Length(1.0, Length.LengthUnit.CENTIMETERS);
        Length inch = new Length(0.393701, Length.LengthUnit.INCHES);

        assertTrue(cm.equals(inch));
    }

    @Test
    public void crossUnitInequality() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(2.0, Length.LengthUnit.FEET);

        assertFalse(yard.equals(feet));
    }

    @Test
    public void sameReference() {

        Length length = new Length(1.0, Length.LengthUnit.YARDS);

        assertTrue(length.equals(length));
    }

    @Test
    public void nullComparison() {

        Length length = new Length(1.0, Length.LengthUnit.YARDS);

        assertFalse(length.equals(null));
    }

    @Test
    public void transitiveProperty() {

        Length yard = new Length(1.0, Length.LengthUnit.YARDS);
        Length feet = new Length(3.0, Length.LengthUnit.FEET);
        Length inches = new Length(36.0, Length.LengthUnit.INCHES);

        assertTrue(yard.equals(feet));
        assertTrue(feet.equals(inches));
        assertTrue(yard.equals(inches));
    }
}
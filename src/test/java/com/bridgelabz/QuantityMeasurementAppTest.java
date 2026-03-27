package com.bridgelabz;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

class QuantityTemperatureTest {

    private static final double EPS = 1e-3;

    // ✅ Equality Tests

    @Test
    void testTemperatureEquality_CelsiusToCelsius() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);

        assertEquals(t1, t2);
    }

    @Test
    void testTemperatureEquality_CelsiusToFahrenheit() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(0.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        assertEquals(t1, t2);
    }

    @Test
    void testTemperatureEquality_Negative40() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(-40.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(-40.0, TemperatureUnit.FAHRENHEIT);

        assertEquals(t1, t2);
    }

    // ✅ Conversion Tests

    @Test
    void testConversion_CelsiusToFahrenheit() {
        Quantity<TemperatureUnit> t = new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(212.0, result.getValue(), EPS);
    }

    @Test
    void testConversion_FahrenheitToCelsius() {
        Quantity<TemperatureUnit> t = new Quantity<>(32.0, TemperatureUnit.FAHRENHEIT);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(0.0, result.getValue(), EPS);
    }

    @Test
    void testConversion_SameUnit() {
        Quantity<TemperatureUnit> t = new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.CELSIUS);

        assertEquals(50.0, result.getValue(), EPS);
    }

    // ❌ Unsupported Operations

    @Test
    void testAddition_NotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.add(t2));
    }

    @Test
    void testSubtraction_NotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.subtract(t2));
    }

    @Test
    void testDivision_NotSupported() {
        Quantity<TemperatureUnit> t1 = new Quantity<>(100.0, TemperatureUnit.CELSIUS);
        Quantity<TemperatureUnit> t2 = new Quantity<>(50.0, TemperatureUnit.CELSIUS);

        assertThrows(UnsupportedOperationException.class,
                () -> t1.divide(t2));
    }

    // ✅ Cross Category Safety

    @Test
    void testTemperatureVsLength_NotEqual() {
        Quantity<TemperatureUnit> temp =
                new Quantity<>(100.0, TemperatureUnit.CELSIUS);

        Length length =
                new Length(100.0, Length.LengthUnit.FEET);

        assertNotEquals(temp, length);
    }

    // ✅ Edge Case

    @Test
    void testVeryHighTemperatureConversion() {
        Quantity<TemperatureUnit> t =
                new Quantity<>(1000.0, TemperatureUnit.CELSIUS);

        Quantity<TemperatureUnit> result =
                t.convertTo(TemperatureUnit.FAHRENHEIT);

        assertEquals(1832.0, result.getValue(), EPS);
    }
}


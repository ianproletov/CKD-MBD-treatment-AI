package ru.proletov.ckdmbd.models.investigations;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasurementTest {

    @Test
    public void testToString() {
        String expected = "mg/dl";
        UnitOfMeasurement currentUnit = UnitOfMeasurement.MGDL;

        assertEquals(expected, currentUnit.toString());
    }

    @Test
    public void testOfEquality() {
        UnitOfMeasurement currentUnit1 = UnitOfMeasurement.MGDL;
        UnitOfMeasurement currentUnit2 = UnitOfMeasurement.MGDL;

        assertEquals(currentUnit1, currentUnit2);
    }
}
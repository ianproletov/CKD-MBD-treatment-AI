package ru.proletov.ckdmbd.models.investigations;

import org.junit.Test;

import static org.junit.Assert.*;

public class UnitOfMeasurementTest {

    @Test
    public void testToString() {
        String expected = "mg/dl";
        AbstractInvestigation.UnitOfMeasurement currentUnit = AbstractInvestigation.UnitOfMeasurement.MGDL;

        assertEquals(expected, currentUnit.toString());
    }

    @Test
    public void testOfEquality() {
        AbstractInvestigation.UnitOfMeasurement currentUnit1 = AbstractInvestigation.UnitOfMeasurement.MGDL;
        AbstractInvestigation.UnitOfMeasurement currentUnit2 = AbstractInvestigation.UnitOfMeasurement.MGDL;

        assertEquals(currentUnit1, currentUnit2);
    }
}
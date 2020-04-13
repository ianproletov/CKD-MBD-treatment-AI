package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaInvestigationTest {

    @Test
    public void testGetValue() {

        double inputValue = 1.8;

        CaInvestigation caInvestigation = new CaInvestigation(inputValue);

        assertEquals(inputValue, caInvestigation.getValue(), 0);

    }

    @Test
    public void testSetValue() {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        CaInvestigation caInvestigation = new CaInvestigation(inputValue);
        caInvestigation.setValue(inputValue2);

        assertEquals(inputValue2, caInvestigation.getValue(), 0);

    }

    @Test
    public void testGetDefaultUnitOfMeasurement() {

        CaInvestigation caInvestigation = new CaInvestigation(2.2);

        assertEquals(UnitOfMeasurement.mmoll, caInvestigation.getUnitOfMeasurement());

    }
}
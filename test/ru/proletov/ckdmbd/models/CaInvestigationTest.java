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

        CaInvestigation caInvestigation = new CaInvestigation(2.1);

        UnitOfMeasurement defaultUnitOfMeasurement = UnitOfMeasurement.mmoll;

        assertEquals(defaultUnitOfMeasurement, caInvestigation.getUnitOfMeasurement());

    }

    @Test
    public void testChangeUnitOfMeasurement1() {
        double inputValue = 2.1;
        CaInvestigation caInvestigation = new CaInvestigation(inputValue);
        caInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.mgdl);
        double expectedValue = inputValue * CaInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.mgdl, caInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, caInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() {
        double inputValue = 8.46;
        CaInvestigation caInvestigation = new CaInvestigation(inputValue, UnitOfMeasurement.mgdl);
        caInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.mmoll);
        double expectedValue = inputValue / CaInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.mmoll, caInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, caInvestigation.getValue(), 0);
    }

}
package ru.proletov.ckdmbd.models;

import org.junit.Test;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.CaInvestigation;
import ru.proletov.ckdmbd.models.investigations.UnitOfMeasurement;

import static org.junit.Assert.*;

public class CaInvestigationTest {

    @Test
    public void testGetValue() throws InvalidUnitOfMeasureException {

        double inputValue = 1.8;

        CaInvestigation caInvestigation = new CaInvestigation(inputValue);

        assertEquals(inputValue, caInvestigation.getValue(), 0);

    }

    @Test
    public void testGetDefaultUnitOfMeasurement() throws InvalidUnitOfMeasureException {

        CaInvestigation caInvestigation = new CaInvestigation(2.1);

        UnitOfMeasurement defaultUnitOfMeasurement = UnitOfMeasurement.MMOLL;

        assertEquals(defaultUnitOfMeasurement, caInvestigation.getUnitOfMeasurement());

    }

    @Test
    public void testChangeUnitOfMeasurement1() throws InvalidUnitOfMeasureException {
        double inputValue = 2.1;
        CaInvestigation caInvestigation = new CaInvestigation(inputValue);
        caInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.MGDL);
        double expectedValue = inputValue * CaInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.MGDL, caInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, caInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        CaInvestigation caInvestigation = new CaInvestigation(inputValue, UnitOfMeasurement.MGDL);
        caInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.MMOLL);
        double expectedValue = inputValue / CaInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.MMOLL, caInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, caInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementToDefault() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        CaInvestigation caInvestigation = new CaInvestigation(inputValue, UnitOfMeasurement.MGDL);
        caInvestigation.changeUnitToDefault();
        double expectedValue = inputValue / CaInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.MMOLL, caInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, caInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementException1() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.MGDL;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.PGML;
        try {
            CaInvestigation caInvestigation = new CaInvestigation(inputValue, inputUnitOfMeasurement);
            caInvestigation.changeUnitOfMeasurement(wrongUnitOfMeasurement);
            fail("Expected InvalidUnitOfMeasureException");
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
        }
    }

    @Test
    public void testChangeUnitOfMeasurementException2() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.MGDL;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.PGML;
        try {
            CaInvestigation caInvestigation = new CaInvestigation(inputValue, wrongUnitOfMeasurement);
            fail();
            caInvestigation.changeUnitOfMeasurement(inputUnitOfMeasurement);
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
        }
    }

}
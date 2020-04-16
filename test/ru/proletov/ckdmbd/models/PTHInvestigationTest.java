package ru.proletov.ckdmbd.models;

import org.junit.Test;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import static org.junit.Assert.*;

public class PTHInvestigationTest {

    @Test
    public void testGetValue() throws InvalidUnitOfMeasureException {
        double inputValue = 150.0;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);
        double pthValue = pthInvestigation.getValue();

        assertEquals(inputValue, pthValue, 0);
    }

    @Test
    public void testSetValue() throws InvalidUnitOfMeasureException {
        PTHInvestigation pthInvestigation = new PTHInvestigation(150);
        double inputValue = 400;
        pthInvestigation.setValue(inputValue);

        assertEquals(inputValue, pthInvestigation.getValue(), 0);

    }

    @Test
    public void testGetUnitOfMeasurement() throws InvalidUnitOfMeasureException {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);

        assertEquals(UnitOfMeasurement.pgml, pthInvestigation.getUnitOfMeasurement());
    }

    @Test
    public void testChangeUnitOfMeasurement1() throws InvalidUnitOfMeasureException {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);
        pthInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.pkmoll);
        double expectedValue = inputValue / PTHInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.pkmoll, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() throws InvalidUnitOfMeasureException {
        double inputValue = 9;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue, UnitOfMeasurement.pkmoll);
        pthInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.pgml);
        double expectedValue = inputValue * PTHInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.pgml, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementToDefault() throws InvalidUnitOfMeasureException {
        double inputValue = 9;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue, UnitOfMeasurement.pkmoll);
        pthInvestigation.changeUnitOfMeasurement();
        double expectedValue = inputValue * PTHInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.pgml, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementException1() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.pgml;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.mgdl;
        try {
            PTHInvestigation pTHInvestigation = new PTHInvestigation(inputValue, inputUnitOfMeasurement);
            pTHInvestigation.changeUnitOfMeasurement(wrongUnitOfMeasurement);
            fail("Expected InvalidUnitOfMeasureException");
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
        }
    }

    @Test
    public void testChangeUnitOfMeasurementException2() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.pgml;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.mgdl;
        try {
            PTHInvestigation pTHInvestigation = new PTHInvestigation(inputValue, wrongUnitOfMeasurement);
            fail();
            pTHInvestigation.changeUnitOfMeasurement(inputUnitOfMeasurement);
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
        }
    }

}
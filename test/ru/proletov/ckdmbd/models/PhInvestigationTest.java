package ru.proletov.ckdmbd.models;

import org.junit.Test;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;
import ru.proletov.ckdmbd.models.investigations.UnitOfMeasurement;

import static org.junit.Assert.*;

public class PhInvestigationTest {

    @Test
    public void testGetValue() throws InvalidUnitOfMeasureException {

        double inputValue = 1.8;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);

        assertEquals(inputValue, phInvestigation.getValue(), 0);

    }

    @Test
    public void testSetValue() throws InvalidUnitOfMeasureException {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);
        phInvestigation.setValue(inputValue2);

        assertEquals(inputValue2, phInvestigation.getValue(), 0);

    }


    @Test
    public void testGetDefauleUnitOfMeasurement() throws InvalidUnitOfMeasureException {

        PhInvestigation phInvestigation = new PhInvestigation(1.9);

        assertEquals(UnitOfMeasurement.mmoll, phInvestigation.getUnitOfMeasurement());

    }

    @Test
    public void testChangeUnitOfMeasurement1() throws InvalidUnitOfMeasureException {
        double inputValue = 2.1;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue);
        phInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.mgdl);
        double expectedValue = inputValue * PhInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.mgdl, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue, UnitOfMeasurement.mgdl);
        phInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.mmoll);
        double expectedValue = inputValue / PhInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.mmoll, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementToDefault() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue, UnitOfMeasurement.mgdl);
        phInvestigation.changeUnitToDefault();
        double expectedValue = inputValue / PhInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.mmoll, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementException1() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.mgdl;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.pgml;
        try {
            PhInvestigation phInvestigation = new PhInvestigation(inputValue, inputUnitOfMeasurement);
            phInvestigation.changeUnitOfMeasurement(wrongUnitOfMeasurement);
            fail("Expected InvalidUnitOfMeasureException");
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
          }
    }

    @Test
    public void testChangeUnitOfMeasurementException2() {
        double inputValue = 8.46;
        UnitOfMeasurement inputUnitOfMeasurement = UnitOfMeasurement.mgdl;
        UnitOfMeasurement wrongUnitOfMeasurement = UnitOfMeasurement.pgml;
        try {
            PhInvestigation phInvestigation = new PhInvestigation(inputValue, wrongUnitOfMeasurement);
            fail();
            phInvestigation.changeUnitOfMeasurement(inputUnitOfMeasurement);
        } catch(final InvalidUnitOfMeasureException e) {
            assertEquals(e.getMessage(),
                    "Can not to proceed this unit of measure" + wrongUnitOfMeasurement);
        }
    }

}
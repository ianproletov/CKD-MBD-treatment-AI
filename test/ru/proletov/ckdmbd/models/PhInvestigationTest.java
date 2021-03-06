package ru.proletov.ckdmbd.models;

import org.junit.Test;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.AbstractInvestigation;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;

import static org.junit.Assert.*;

public class PhInvestigationTest {

    @Test
    public void testGetValue() throws InvalidUnitOfMeasureException {

        double inputValue = 1.8;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);

        assertEquals(inputValue, phInvestigation.getValue(), 0);

    }

    @Test
    public void testGetDefauleUnitOfMeasurement() throws InvalidUnitOfMeasureException {

        PhInvestigation phInvestigation = new PhInvestigation(1.9);

        assertEquals(AbstractInvestigation.UnitOfMeasurement.MMOLL, phInvestigation.getUnitOfMeasurement());

    }

    @Test
    public void testChangeUnitOfMeasurement1() throws InvalidUnitOfMeasureException {
        double inputValue = 2.1;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue);
        phInvestigation.changeUnitOfMeasurement(AbstractInvestigation.UnitOfMeasurement.MGDL);
        double expectedValue = inputValue * PhInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.MGDL, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue, AbstractInvestigation.UnitOfMeasurement.MGDL);
        phInvestigation.changeUnitOfMeasurement(AbstractInvestigation.UnitOfMeasurement.MMOLL);
        double expectedValue = inputValue / PhInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.MMOLL, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementToDefault() throws InvalidUnitOfMeasureException {
        double inputValue = 8.46;
        PhInvestigation phInvestigation = new PhInvestigation(inputValue, AbstractInvestigation.UnitOfMeasurement.MGDL);
        phInvestigation.changeUnitToDefault();
        double expectedValue = inputValue / PhInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.MMOLL, phInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, phInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementException1() {
        double inputValue = 8.46;
        AbstractInvestigation.UnitOfMeasurement inputUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.MGDL;
        AbstractInvestigation.UnitOfMeasurement wrongUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.PGML;
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
        AbstractInvestigation.UnitOfMeasurement inputUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.MGDL;
        AbstractInvestigation.UnitOfMeasurement wrongUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.PGML;
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
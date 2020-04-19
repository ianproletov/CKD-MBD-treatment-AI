package ru.proletov.ckdmbd.models;

import org.junit.Test;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.AbstractInvestigation;
import ru.proletov.ckdmbd.models.investigations.PTHInvestigation;

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
    public void testGetUnitOfMeasurement() throws InvalidUnitOfMeasureException {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);

        assertEquals(AbstractInvestigation.UnitOfMeasurement.PGML, pthInvestigation.getUnitOfMeasurement());
    }

    @Test
    public void testChangeUnitOfMeasurement1() throws InvalidUnitOfMeasureException {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);
        pthInvestigation.changeUnitOfMeasurement(AbstractInvestigation.UnitOfMeasurement.PKMOLL);
        double expectedValue = inputValue / PTHInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.PKMOLL, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() throws InvalidUnitOfMeasureException {
        double inputValue = 9;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue, AbstractInvestigation.UnitOfMeasurement.PKMOLL);
        pthInvestigation.changeUnitOfMeasurement(AbstractInvestigation.UnitOfMeasurement.PGML);
        double expectedValue = inputValue * PTHInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.PGML, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementToDefault() throws InvalidUnitOfMeasureException {
        double inputValue = 9;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue, AbstractInvestigation.UnitOfMeasurement.PKMOLL);
        pthInvestigation.changeUnitToDefault();
        double expectedValue = inputValue * PTHInvestigation.GetConverter();

        assertEquals(AbstractInvestigation.UnitOfMeasurement.PGML, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurementException1() {
        double inputValue = 8.46;
        AbstractInvestigation.UnitOfMeasurement inputUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.PGML;
        AbstractInvestigation.UnitOfMeasurement wrongUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.MGDL;
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
        AbstractInvestigation.UnitOfMeasurement inputUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.PGML;
        AbstractInvestigation.UnitOfMeasurement wrongUnitOfMeasurement = AbstractInvestigation.UnitOfMeasurement.MGDL;
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
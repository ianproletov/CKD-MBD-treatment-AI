package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PTHInvestigationTest {

    @Test
    public void testGetValue() {
        double inputValue = 150.0;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);
        double pthValue = pthInvestigation.getValue();

        assertEquals(inputValue, pthValue, 0);
    }

    @Test
    public void testSetValue() {
        PTHInvestigation pthInvestigation = new PTHInvestigation(150);
        double inputValue = 400;
        pthInvestigation.setValue(inputValue);

        assertEquals(inputValue, pthInvestigation.getValue(), 0);

    }

    @Test
    public void testGetUnitOfMeasurement() {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);

        assertEquals(UnitOfMeasurement.pgml, pthInvestigation.getUnitOfMeasurement());
    }

    @Test
    public void testChangeUnitOfMeasurement1() {
        double inputValue = 150;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue);
        pthInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.pkmoll);
        double expectedValue = inputValue / PTHInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.pkmoll, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() {
        double inputValue = 9;
        PTHInvestigation pthInvestigation = new PTHInvestigation(inputValue, UnitOfMeasurement.pkmoll);
        pthInvestigation.changeUnitOfMeasurement(UnitOfMeasurement.pgml);
        double expectedValue = inputValue * PTHInvestigation.GetConverter();

        assertEquals(UnitOfMeasurement.pgml, pthInvestigation.getUnitOfMeasurement());
        assertEquals(expectedValue, pthInvestigation.getValue(), 0);
    }

}
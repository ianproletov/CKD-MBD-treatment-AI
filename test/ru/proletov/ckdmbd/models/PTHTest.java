package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PTHTest {

    @Test
    public void testGetValue() {
        double inputValue = 150.0;
        PTH pthResult = new PTH(inputValue);
        double pthValue = pthResult.getValue();

        assertEquals(inputValue, pthValue, 0);
    }

    @Test
    public void testSetValue() {
        PTH pthResult = new PTH(150);
        double inputValue = 400;
        pthResult.setValue(inputValue);

        assertEquals(inputValue, pthResult.getValue(), 0);

    }

    @Test
    public void testGetUnitOfMeasurement() {
        double inputValue = 150;
        PTH pthResult = new PTH(inputValue);

        assertEquals(PTH.UnitOfMeasurement.pgml, pthResult.getUnitOfMeasurement());
    }

    @Test
    public void testChangeUnitOfMeasurement1() {
        double inputValue = 150;
        PTH pthResult = new PTH(inputValue);
        pthResult.changeUnitOfMeasurement(PTH.UnitOfMeasurement.pkmoll);
        double expectedValue = inputValue / PTH.GetConverter();

        assertEquals(PTH.UnitOfMeasurement.pkmoll, pthResult.getUnitOfMeasurement());
        assertEquals(expectedValue, pthResult.getValue(), 0);
    }

    @Test
    public void testChangeUnitOfMeasurement2() {
        double inputValue = 9;
        PTH pthResult = new PTH(inputValue, PTH.UnitOfMeasurement.pkmoll);
        pthResult.changeUnitOfMeasurement(PTH.UnitOfMeasurement.pgml);
        double expectedValue = inputValue * PTH.GetConverter();

        assertEquals(PTH.UnitOfMeasurement.pgml, pthResult.getUnitOfMeasurement());
        assertEquals(expectedValue, pthResult.getValue(), 0);
    }

}
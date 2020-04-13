package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhInvestigationTest {

    @Test
    public void testGetValue() {

        double inputValue = 1.8;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);

        assertEquals(inputValue, phInvestigation.getValue(), 0);

    }

    @Test
    public void testSetValue() {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);
        phInvestigation.setValue(inputValue2);

        assertEquals(inputValue2, phInvestigation.getValue(), 0);

    }


    @Test
    public void testGetDefauleUnitOfMeasurement() {

        PhInvestigation phInvestigation = new PhInvestigation(1.9);

        assertEquals(UnitOfMeasurement.mmoll, phInvestigation.getUnitOfMeasurement());

    }
}
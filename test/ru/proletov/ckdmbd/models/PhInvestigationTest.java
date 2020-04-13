package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhInvestigationTest {

    @Test
    public void getValue() {

        double inputValue = 1.8;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);

        assertEquals(inputValue, phInvestigation.getValue(), 0);

    }

    @Test
    public void setValue() {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        PhInvestigation phInvestigation = new PhInvestigation(inputValue);
        phInvestigation.setValue(inputValue2);

        assertEquals(inputValue2, phInvestigation.getValue(), 0);

    }


    @Test
    public void getUnitOfMeasurement() {

        PhInvestigation phInvestigation = new PhInvestigation(1.9);

        assertEquals(UnitOfMeasurement.mmoll, phInvestigation.getUnitOfMeasurement());

    }
}
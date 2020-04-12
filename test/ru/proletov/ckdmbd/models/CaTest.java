package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class CaTest {

    @Test
    public void testGetValue() {

        double inputValue = 1.8;

        Ca caResult = new Ca(inputValue);

        assertEquals(inputValue, caResult.getValue(), 0);

    }

    @Test
    public void testSetValue() {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        Ca caResult = new Ca(inputValue);
        caResult.setValue(inputValue2);

        assertEquals(inputValue2, caResult.getValue(), 0);

    }
}
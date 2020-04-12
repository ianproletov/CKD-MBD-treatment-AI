package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PhTest {

    @Test
    public void getValue() {

        double inputValue = 1.8;

        Ph phResult = new Ph(inputValue);

        assertEquals(inputValue, phResult.getValue(), 0);

    }

    @Test
    public void setValue() {

        double inputValue = 1.8;
        double inputValue2 = 1.47;

        Ph phResult = new Ph(inputValue);
        phResult.setValue(inputValue2);

        assertEquals(inputValue2, phResult.getValue(), 0);

    }
}
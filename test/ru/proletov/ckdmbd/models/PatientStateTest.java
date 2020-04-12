package ru.proletov.ckdmbd.models;

import org.junit.Test;

import static org.junit.Assert.*;

public class PatientStateTest {
    double inputCaLevel = 1.9;
    double inputPhLevel = 1.3;
    double inputPTHLevel = 800;
    PTH inputPTH = new PTH(inputPTHLevel);
    PatientState patientState = new PatientState(new Ca(inputCaLevel), new Ph(inputPhLevel), inputPTH);

    @Test
    public void testGetCalcium() {
        double currentCalciumLevel = patientState.getCalcium().getValue();

        assertEquals(inputCaLevel, currentCalciumLevel, 0);
    }

    @Test
    public void getPhosphorusLevel() {
        double currentPhLevel = patientState.getPhosphorus().getValue();

        assertEquals(inputPhLevel, currentPhLevel, 0);
    }

    @Test
    public void getPthLevel() {

        assertEquals(inputPTH, patientState.getPTH());

    }
}
package ru.proletov.ckdmbd.controllers;

import org.junit.Test;
import ru.proletov.ckdmbd.models.*;

import static org.junit.Assert.*;

public class RecommendationMakerTest {

    @Test
    public void makeRecommendation() {

        PatientState patientState = new PatientState(new Ca(2.0), new Ph(1.3), new PTH(800));
        RecommendationMaker recommendationMaker = new RecommendationMaker();
        Recommendation recommendation = recommendationMaker.makeRecommendation(patientState);

        TherapyChange expectedActiveD3 = TherapyChange.start;

        assertEquals(expectedActiveD3, recommendation.getActiveD3());

    }
}
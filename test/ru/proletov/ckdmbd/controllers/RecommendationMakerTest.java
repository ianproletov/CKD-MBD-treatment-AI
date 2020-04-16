package ru.proletov.ckdmbd.controllers;

import org.junit.Test;
import ru.proletov.ckdmbd.models.*;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.investigations.CaInvestigation;
import ru.proletov.ckdmbd.models.investigations.PTHInvestigation;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;

import static org.junit.Assert.*;

public class RecommendationMakerTest {

    @Test
    public void makeRecommendation() throws InvalidUnitOfMeasureException {

        PatientState patientState = new PatientState(new CaInvestigation(2.0),
                new PhInvestigation(1.3),
                new PTHInvestigation(800));
        RecommendationMaker recommendationMaker = new RecommendationMaker();
        Recommendation recommendation = recommendationMaker.makeRecommendation(patientState);

        TherapyChange expectedActiveD3 = TherapyChange.start;

        assertEquals(expectedActiveD3, recommendation.getActiveD3());

    }
}
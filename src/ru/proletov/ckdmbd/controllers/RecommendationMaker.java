package ru.proletov.ckdmbd.controllers;

import ru.proletov.ckdmbd.models.*;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

public class RecommendationMaker {

    public Recommendation makeRecommendation(final PatientState patientState) throws InvalidUnitOfMeasureException {

        double currentCaLevel = patientState.getCalcium().getValue();

        double currentPhLevel = patientState.getPhosphorus().getValue();

        double currentPTHLevel = patientState.getPTH().changeUnitOfMeasurement(UnitOfMeasurement.pgml).getValue();

        boolean isActiveD3started = patientState.isActiveD3Use();

        boolean isCalcinineticsStarted = patientState.isCalcimimeticsUse();

        boolean isCaBindersStarted = patientState.isCaPhBindersUse();

        boolean isNoCaBindersStarted = patientState.isActiveD3Use();

        Recommendation result = new Recommendation();

        if (currentCaLevel < 2.1 && currentPhLevel < 1.78 && currentPTHLevel > 600) {
            result.setActiveD3((isActiveD3started) ? TherapyChange.increase : TherapyChange.start);
            result.setCaBinders((isCaBindersStarted) ? TherapyChange.retain : TherapyChange.start);
            result.setCalcimimetics((isCalcinineticsStarted) ? TherapyChange.retain : TherapyChange.nostart);
            result.setNoCaBinders((isNoCaBindersStarted) ? TherapyChange.retain : TherapyChange.nostart);
        }

  //      result.setActiveD3();
   //     result.setCaBinders();
   //     result.setCalcimimetics();
   //     result.setNoCaBinders();

        return result;
    }

}

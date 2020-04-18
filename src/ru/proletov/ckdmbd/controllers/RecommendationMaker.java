package ru.proletov.ckdmbd.controllers;

import ru.proletov.ckdmbd.models.*;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.levels.Levels;
import static ru.proletov.ckdmbd.models.levels.Levels.*;


public class RecommendationMaker {

    public Recommendation makeRecommendation(final PatientState patientState) throws InvalidUnitOfMeasureException {
        double currentCaLevel = patientState.getCalcium().changeUnitToDefault().getValue();
        double currentPhLevel = patientState.getPhosphorus().changeUnitToDefault().getValue();
        double currentPTHLevel = patientState.getPTH().changeUnitToDefault().getValue();
        boolean isActiveD3started = patientState.isActiveD3Use();
        boolean isCalcimimeticsStarted = patientState.isCalcimimeticsUse();
        boolean isCaBindersStarted = patientState.isCaPhBindersUse();
        boolean isNoCaBindersStarted = patientState.isActiveD3Use();

        Recommendation result = new Recommendation();

        State[] states = new State[]{
                new State(
                        (currentCaLevel < CA_LOW && currentPhLevel < PH_HI && currentPTHLevel > PTH_HI),
                        new Recommendation()
                                .setActiveD3((isActiveD3started) ? TherapyChange.increase : TherapyChange.start)
                                .setCaBinders((isCaBindersStarted) ? TherapyChange.retain : TherapyChange.start)
                                .setCalcimimetics((isCalcimimeticsStarted)
                                        ? TherapyChange.retain : TherapyChange.nostart)
                                .setNoCaBinders((isNoCaBindersStarted) ? TherapyChange.retain : TherapyChange.nostart)
                )
        };

        for (State state: states) {
            if (state.getState()) {
                return state.getResult();
            }
        }
    return null; // м.б. должно быть исключение
    }

}

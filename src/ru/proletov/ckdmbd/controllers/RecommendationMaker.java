package ru.proletov.ckdmbd.controllers;

import ru.proletov.ckdmbd.models.*;
import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;
import ru.proletov.ckdmbd.models.levels.*;


public class RecommendationMaker {
    ILevel caLevels;
    ILevel phLevels;
    ILevel pTHLevels;

    public RecommendationMaker() {
        this(new defCaLevels(), new defPhLevels(), new defPTHLevels());
    }

    public RecommendationMaker(final ICaLevels caLevels,   //м.б. нужно реализовать паттерн builder или вложенный класс
                               final IPhLevels phLevels,
                               final IPTHLevels pTHLevels) {
        this.caLevels = caLevels;
        this.phLevels = phLevels;
        this.pTHLevels = pTHLevels;
    }

    public Recommendation makeRecommendation(final PatientState patientState) throws InvalidUnitOfMeasureException {
        double currentCaLevel = patientState.getCalcium().changeUnitToDefault().getValue();
        double currentPhLevel = patientState.getPhosphorus().changeUnitToDefault().getValue();
        double currentPTHLevel = patientState.getPTH().changeUnitToDefault().getValue();
        double lowCaLevel = caLevels.getLow();
        double hiCaLevel = caLevels.getHi();
        double lowPhLevel = phLevels.getLow();
        double hiPhLevel = phLevels.getHi();
        double lowPTHLevel = pTHLevels.getLow();
        double hiPTHLevel = pTHLevels.getHi();
        boolean isActiveD3started = patientState.isActiveD3Use();
        boolean isCalcimimeticsStarted = patientState.isCalcimimeticsUse();
        boolean isCaBindersStarted = patientState.isCaPhBindersUse();
        boolean isNoCaBindersStarted = patientState.isActiveD3Use();

        Recommendation result = new Recommendation();

        State[] states = new State[]{
                new State(
                        (currentCaLevel < lowCaLevel && currentPhLevel < hiPhLevel && currentPTHLevel > hiPTHLevel),
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

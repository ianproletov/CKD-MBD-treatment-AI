package ru.proletov.ckdmbd.models;

public class PatientState {

    private Ca calciumLevel;

    private Ph phosphorusLevel;

    private PTH pthLevel;

    private boolean calcimimeticsUse;

    private boolean caPhBindersUse;

    private boolean noCaPhBindersUse;

    private boolean activeD3Use;

    public PatientState(final Ca calciumLevel, final Ph phosphorusLevel, final PTH pthLevel) {
        this(calciumLevel,
             phosphorusLevel,
             pthLevel,
            false,
            false,
            false,
            false);
    }

    public PatientState(final Ca calciumLevel,
                        final Ph phosphorusLevel,
                        final PTH pthLevel,
                        final boolean calcimimeticsUse,
                        final boolean caPhBindersUse,
                        final boolean noCaPhBindersUse,
                        final boolean activeD3Use) {
        this.calciumLevel = calciumLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.pthLevel = pthLevel;
        this.calcimimeticsUse = calcimimeticsUse;
        this.caPhBindersUse = caPhBindersUse;
        this.noCaPhBindersUse = noCaPhBindersUse;
        this.activeD3Use = activeD3Use;
    }
}

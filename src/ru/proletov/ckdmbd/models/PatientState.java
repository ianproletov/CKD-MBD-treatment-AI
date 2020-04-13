package ru.proletov.ckdmbd.models;

public class PatientState {

    private CaInvestigation calciumLevel;

    private PhInvestigation phosphorusLevel;

    private PTHInvestigation pthInvestigationLevel;

    private boolean calcimimeticsUse;

    private boolean caPhBindersUse;

    private boolean noCaPhBindersUse;

    private boolean activeD3Use;

    public PatientState(final CaInvestigation calciumLevel, final PhInvestigation phosphorusLevel, final PTHInvestigation pthInvestigationLevel) {
        this(calciumLevel,
             phosphorusLevel,
                pthInvestigationLevel,
            false,
            false,
            false,
            false);
    }

    public PatientState(final CaInvestigation calciumLevel,
                        final PhInvestigation phosphorusLevel,
                        final PTHInvestigation pthInvestigationLevel,
                        final boolean calcimimeticsUse,
                        final boolean caPhBindersUse,
                        final boolean noCaPhBindersUse,
                        final boolean activeD3Use) {
        this.calciumLevel = calciumLevel;
        this.phosphorusLevel = phosphorusLevel;
        this.pthInvestigationLevel = pthInvestigationLevel;
        this.calcimimeticsUse = calcimimeticsUse;
        this.caPhBindersUse = caPhBindersUse;
        this.noCaPhBindersUse = noCaPhBindersUse;
        this.activeD3Use = activeD3Use;
    }

    public CaInvestigation getCalcium() {
        return calciumLevel;
    }

    public PhInvestigation getPhosphorus() {
        return phosphorusLevel;
    }

    public PTHInvestigation getPTH() {
        return pthInvestigationLevel;
    }

    public boolean isCalcimimeticsUse() {
        return calcimimeticsUse;
    }

    public boolean isCaPhBindersUse() {
        return caPhBindersUse;
    }

    public boolean isNoCaPhBindersUse() {
        return noCaPhBindersUse;
    }

    public boolean isActiveD3Use() {
        return activeD3Use;
    }
}

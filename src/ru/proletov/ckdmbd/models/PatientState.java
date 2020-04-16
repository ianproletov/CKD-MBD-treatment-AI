package ru.proletov.ckdmbd.models;

import ru.proletov.ckdmbd.models.investigations.CaInvestigation;
import ru.proletov.ckdmbd.models.investigations.PTHInvestigation;
import ru.proletov.ckdmbd.models.investigations.PhInvestigation;

public class PatientState {

    private CaInvestigation caInvestigation;

    private PhInvestigation phInvestigation;

    private PTHInvestigation pthInvestigation;

    private boolean calcimimeticsUse;

    private boolean caPhBindersUse;

    private boolean noCaPhBindersUse;

    private boolean activeD3Use;

    public PatientState(final CaInvestigation caInvestigation,
                        final PhInvestigation phInvestigation,
                        final PTHInvestigation pthInvestigation) {
        this(caInvestigation,
                phInvestigation,
                pthInvestigation,
               false,
               false,
               false,
               false);
    }

    public PatientState(final CaInvestigation caInvestigation,
                        final PhInvestigation phInvestigation,
                        final PTHInvestigation pthInvestigation,
                        final boolean calcimimeticsUse,
                        final boolean caPhBindersUse,
                        final boolean noCaPhBindersUse,
                        final boolean activeD3Use) {
        this.caInvestigation = caInvestigation;
        this.phInvestigation = phInvestigation;
        this.pthInvestigation = pthInvestigation;
        this.calcimimeticsUse = calcimimeticsUse;
        this.caPhBindersUse = caPhBindersUse;
        this.noCaPhBindersUse = noCaPhBindersUse;
        this.activeD3Use = activeD3Use;
    }

    public CaInvestigation getCalcium() {
        return caInvestigation;
    }

    public PhInvestigation getPhosphorus() {
        return phInvestigation;
    }

    public PTHInvestigation getPTH() {
        return pthInvestigation;
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

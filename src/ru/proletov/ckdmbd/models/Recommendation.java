package ru.proletov.ckdmbd.models;

public class Recommendation {

    private TherapyChange calcimimetics;

    private TherapyChange caBinders;

    private TherapyChange noCaBinders;

    private TherapyChange activeD3;

    public TherapyChange getCalcimimetics() {
        return calcimimetics;
    }

    public TherapyChange getCaBinders() {
        return caBinders;
    }

    public TherapyChange getNoCaBinders() {
        return noCaBinders;
    }

    public TherapyChange getActiveD3() {
        return activeD3;
    }

    public void setCalcimimetics(TherapyChange calcimimetics) {
        this.calcimimetics = calcimimetics;
    }

    public void setCaBinders(TherapyChange caBinders) {
        this.caBinders = caBinders;
    }

    public void setNoCaBinders(TherapyChange noCaBinders) {
        this.noCaBinders = noCaBinders;
    }

    public void setActiveD3(TherapyChange activeD3) {
        this.activeD3 = activeD3;
    }
}

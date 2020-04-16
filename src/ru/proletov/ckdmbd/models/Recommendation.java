package ru.proletov.ckdmbd.models;

public class Recommendation {

    private TherapyChange calcimimetics;

    private TherapyChange caBinders;

    private TherapyChange noCaBinders;

    private TherapyChange activeD3;

    public Recommendation() {
        this.calcimimetics = TherapyChange.retain;
        this.caBinders = TherapyChange.retain;
        this.noCaBinders = TherapyChange.retain;
        this.activeD3 = TherapyChange.retain;
    }

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

    public Recommendation setCalcimimetics(TherapyChange calcimimetics) {
        this.calcimimetics = calcimimetics;
        return this;
    }

    public Recommendation setCaBinders(TherapyChange caBinders) {
        this.caBinders = caBinders;
        return this;
    }

    public Recommendation setNoCaBinders(TherapyChange noCaBinders) {
        this.noCaBinders = noCaBinders;
        return this;
    }

    public Recommendation setActiveD3(TherapyChange activeD3) {
        this.activeD3 = activeD3;
        return this;
    }
}

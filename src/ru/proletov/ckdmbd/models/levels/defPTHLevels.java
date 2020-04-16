package ru.proletov.ckdmbd.models.levels;

public class defPTHLevels implements IPTHLevels {
    private double HI = 600;
    private double LOW = 150;

    @Override
    public double getHi() {
        return HI;
    }

    @Override
    public double getLow() {
        return LOW;
    }

}

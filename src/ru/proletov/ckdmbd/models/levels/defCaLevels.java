package ru.proletov.ckdmbd.models.levels;

public class defCaLevels implements ICaLevels {
    private double HI = 2.5;
    private double LOW = 2.1;

    @Override
    public double getHi() {
        return HI;
    }

    @Override
    public double getLow() {
        return LOW;
    }
}

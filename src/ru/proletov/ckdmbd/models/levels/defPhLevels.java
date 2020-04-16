package ru.proletov.ckdmbd.models.levels;

public class defPhLevels implements IPhLevels {
    private double HI = 1.78;
    private double LOW = 0.87;

    @Override
    public double getHi() {
        return HI;
    }

    @Override
    public double getLow() {
        return LOW;
    }
}

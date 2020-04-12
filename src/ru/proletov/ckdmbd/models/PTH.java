package ru.proletov.ckdmbd.models;

public class PTH extends LaboratoryInvestigation {

    private UnitOfMeasurement unitOfMeasurement;

    public PTH(final float value) {
        super(value);
        this.unitOfMeasurement = UnitOfMeasurement.pgml;
    }

    public PTH(final float value, final UnitOfMeasurement unitOfMeasurement ) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    private enum UnitOfMeasurement {
        pgml, pkmoldl
    }

}

package ru.proletov.ckdmbd.models;

public class CaInvestigation extends AbstractInvestigation {

    public CaInvestigation(final double value) {
        this(value, UnitOfMeasurement.mmoll);
    }

    public CaInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public PTHInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        return null;
    }

}

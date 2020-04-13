package ru.proletov.ckdmbd.models;

public class PhInvestigation extends AbstractInvestigation {

    public PhInvestigation(final double value) {
        this(value, UnitOfMeasurement.mmoll);
    }

    public PhInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public PTHInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        return null;
    }
}

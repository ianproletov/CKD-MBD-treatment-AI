package ru.proletov.ckdmbd.models;

abstract class AbstractInvestigation {

    protected double value;

    protected UnitOfMeasurement unitOfMeasurement;

    protected AbstractInvestigation(final double value) {
        this.value = value;
    }

    abstract PTHInvestigation changeUnitOfMeasurement(final UnitOfMeasurement unitOfMeasurement);

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public double getValue() {
        return value;
    }

    protected void setValue(final double value) {
        this.value = value;
    }

}
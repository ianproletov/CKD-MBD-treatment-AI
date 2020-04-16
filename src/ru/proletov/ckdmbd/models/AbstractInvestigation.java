package ru.proletov.ckdmbd.models;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

abstract class AbstractInvestigation {
    protected double value;

    protected UnitOfMeasurement unitOfMeasurement;

    protected AbstractInvestigation(final double value) {
        this.value = value;
    }

    abstract AbstractInvestigation changeUnitOfMeasurement(final UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException;

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

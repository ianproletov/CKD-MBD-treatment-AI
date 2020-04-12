package ru.proletov.ckdmbd.models;

public abstract class LaboratoryInvestigation {

    protected double value;

    protected String unitOfMeasurement;

    protected LaboratoryInvestigation(final double value) {
        this.value = value;
    }

    protected double getValue() {
        return value;
    }

    protected void setValue(final double value) {
        this.value = value;
    }

}

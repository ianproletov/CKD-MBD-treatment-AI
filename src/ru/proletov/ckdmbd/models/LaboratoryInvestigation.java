package ru.proletov.ckdmbd.models;

public class LaboratoryInvestigation {

    private float value;

    protected String unitOfMeasurement;

    public LaboratoryInvestigation(final float value) {
        this.value = value;
    }

    public float getValue() {
        return value;
    }

    public void setValue(final float value) {
        this.value = value;
    }

}

package ru.proletov.ckdmbd.models;

public class CaInvestigation extends AbstractInvestigation {

    private static final double CONVERTER = 4;

    public CaInvestigation(final double value) {
        this(value, UnitOfMeasurement.mmoll);
    }

    public CaInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public CaInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) {
        if (unitOfMeasurement == this.unitOfMeasurement) return this;
        double currentConverter = CONVERTER;
        switch (unitOfMeasurement) {
            case mgdl:
                this.unitOfMeasurement = UnitOfMeasurement.mgdl;
                break;
            case mmoll:
                this.unitOfMeasurement = UnitOfMeasurement.mmoll;
                currentConverter = 1 / CONVERTER;
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + unitOfMeasurement);
        }
        this.value = this.value * currentConverter;
        return this;
    }

    public static double GetConverter() {
        return CONVERTER;
    }

}

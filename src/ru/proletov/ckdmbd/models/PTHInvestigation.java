package ru.proletov.ckdmbd.models;

public class PTHInvestigation extends AbstractInvestigation {

    private static final double CONVERTER = 9.43;

    public PTHInvestigation(final double value) {
        this(value, UnitOfMeasurement.pgml);
    }

    public PTHInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement ) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    @Override
    public PTHInvestigation changeUnitOfMeasurement(final UnitOfMeasurement unitOfMeasurement) {
        if (unitOfMeasurement == this.unitOfMeasurement) return this;
        double currentConverter = CONVERTER;
        switch (unitOfMeasurement) {
            case pgml:
                this.unitOfMeasurement = UnitOfMeasurement.pgml;
                break;
            case pkmoll:
                this.unitOfMeasurement = UnitOfMeasurement.pkmoll;
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

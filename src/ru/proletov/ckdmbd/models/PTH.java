package ru.proletov.ckdmbd.models;

public class PTH extends LaboratoryInvestigation {

    private PTH.UnitOfMeasurement unitOfMeasurement;

    private static double CONVERTER = 9.43;

    public PTH(final double value) {
        super(value);
        this.unitOfMeasurement = PTH.UnitOfMeasurement.pgml;
    }

    public PTH(final double value, final PTH.UnitOfMeasurement unitOfMeasurement ) {
        super(value);
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public PTH.UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public void changeUnitOfMeasurement(final PTH.UnitOfMeasurement unitOfMeasurement) {
        if (unitOfMeasurement == this.unitOfMeasurement) return;
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
    }

    public enum UnitOfMeasurement {
        pgml, pkmoll
    }

    public static double GetConverter() {
        return CONVERTER;
    }

}

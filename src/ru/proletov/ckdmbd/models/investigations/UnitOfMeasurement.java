package ru.proletov.ckdmbd.models.investigations;

public enum UnitOfMeasurement {
    PGML("pg/ml"), PKMOLL("pkmok/l"), MMOLL("mmol/l"), MGDL("mg/dl");

    private final String unit;

    UnitOfMeasurement(final String unit) {
        this.unit = unit;
    }

    @Override
    public String toString() {
        return unit;
    }
}

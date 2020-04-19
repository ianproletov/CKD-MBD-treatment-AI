package ru.proletov.ckdmbd.models.investigations;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

public abstract class AbstractInvestigation {
    private double value;

    protected UnitOfMeasurement unitOfMeasurement;

    protected AbstractInvestigation(final double value) {
        this.value = value;
    }

    abstract AbstractInvestigation changeUnitOfMeasurement()
            throws InvalidUnitOfMeasureException;

    abstract AbstractInvestigation changeUnitOfMeasurement(final UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException;

    public UnitOfMeasurement getUnitOfMeasurement() {
        return unitOfMeasurement;
    }

    public double getValue() {
        return value;
    }

    public AbstractInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement();
    }

    protected void setValue(final double value) {
        this.value = value;
    }

    public enum UnitOfMeasurement {
        PGML("pg/ml"), PKMOLL("pkmol/l"), MMOLL("mmol/l"), MGDL("mg/dl");

        private final String unit;

        UnitOfMeasurement(final String unit) {
            this.unit = unit;
        }

        @Override
        public String toString() {
            return unit;
        }
    }
}

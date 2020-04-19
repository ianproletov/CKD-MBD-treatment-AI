package ru.proletov.ckdmbd.models.investigations;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import java.util.Arrays;

public class CaInvestigation extends AbstractInvestigation {
    private static final double CONVERTER = 4;
    private static UnitOfMeasurement[] validUnits = {UnitOfMeasurement.mmoll, UnitOfMeasurement.mgdl};
    private static UnitOfMeasurement DEFAULT_UNIT = UnitOfMeasurement.mmoll;

    public CaInvestigation(final double value) throws InvalidUnitOfMeasureException {
        this(value, DEFAULT_UNIT);
    }

    public CaInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException {
        super(value);
        if (Arrays.asList(validUnits).contains(unitOfMeasurement)) {
            this.unitOfMeasurement = unitOfMeasurement;
        } else {
            throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
    }

    @Override
    public CaInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException {
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
                throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
        this.setValue(this.getValue() * currentConverter);
        return this;
    }

    public CaInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement(DEFAULT_UNIT);
    }

    public static double GetConverter() {
        return CONVERTER;
    }

}

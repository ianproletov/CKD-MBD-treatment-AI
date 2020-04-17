package ru.proletov.ckdmbd.models.investigations;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import java.util.Arrays;

public class CaInvestigation extends AbstractInvestigation {
    private final static UnitOfMeasurement[] validUnits = {UnitOfMeasurement.mmoll, UnitOfMeasurement.mgdl};
    private final static UnitOfMeasurement DEFAULT_UNIT = UnitOfMeasurement.mmoll;

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
        converter = 4;
    }

    @Override
    public CaInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException {
        if (unitOfMeasurement == this.unitOfMeasurement) return this;
        double currentConverter = converter;
        switch (unitOfMeasurement) {
            case mgdl:
                this.unitOfMeasurement = UnitOfMeasurement.mgdl;
                break;
            case mmoll:
                this.unitOfMeasurement = UnitOfMeasurement.mmoll;
                currentConverter = 1 / converter;
                break;
            default:
                throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
        this.value = this.value * currentConverter;
        return this;
    }

    public CaInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement(DEFAULT_UNIT);
    }

    public static double GetConverter() {
        return converter;
    }

}

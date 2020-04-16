package ru.proletov.ckdmbd.models.investigations;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import java.util.Arrays;

public class PhInvestigation extends AbstractInvestigation {
    private static final double CONVERTER = 3.1;
    private static UnitOfMeasurement[] validUnits = {UnitOfMeasurement.mmoll, UnitOfMeasurement.mgdl};
    private static UnitOfMeasurement DEFAULT_UNIT = UnitOfMeasurement.mmoll;

    public PhInvestigation(final double value) throws InvalidUnitOfMeasureException {
        this(value, UnitOfMeasurement.mmoll);
    }

    public PhInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException {
        super(value);
        if (Arrays.asList(validUnits).contains(unitOfMeasurement)) {
            this.unitOfMeasurement = unitOfMeasurement;
        } else {
            throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
     }

    @Override
    public PhInvestigation changeUnitOfMeasurement(UnitOfMeasurement unitOfMeasurement) throws InvalidUnitOfMeasureException {
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
        this.value = this.value * currentConverter;
        return this;
    }

    public PhInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement(DEFAULT_UNIT);
    }

    public static double GetConverter() {
        return CONVERTER;
    }
}

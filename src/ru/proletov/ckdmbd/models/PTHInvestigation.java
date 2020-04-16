package ru.proletov.ckdmbd.models;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import java.util.Arrays;

public class PTHInvestigation extends AbstractInvestigation {
    private static final double CONVERTER = 9.43;
    private static UnitOfMeasurement[] validUnits = {UnitOfMeasurement.pgml, UnitOfMeasurement.pkmoll};
    private static UnitOfMeasurement DEFAULT_UNIT = UnitOfMeasurement.pgml;

    public PTHInvestigation(final double value) throws InvalidUnitOfMeasureException {
        this(value, UnitOfMeasurement.pgml);
    }

    public PTHInvestigation(final double value, final UnitOfMeasurement unitOfMeasurement )
            throws InvalidUnitOfMeasureException {
        super(value);
        if (Arrays.asList(validUnits).contains(unitOfMeasurement)) {
            this.unitOfMeasurement = unitOfMeasurement;
        } else {
            throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
    }

    @Override
    public PTHInvestigation changeUnitOfMeasurement(final UnitOfMeasurement unitOfMeasurement)
            throws InvalidUnitOfMeasureException {
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
                throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
        this.value = this.value * currentConverter;
        return this;
    }

    public PTHInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement(DEFAULT_UNIT);
    }

    public static double GetConverter() {
        return CONVERTER;
    }

}

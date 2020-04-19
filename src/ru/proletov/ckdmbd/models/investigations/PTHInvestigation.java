package ru.proletov.ckdmbd.models.investigations;

import ru.proletov.ckdmbd.models.exceptions.InvalidUnitOfMeasureException;

import java.util.Arrays;

public class PTHInvestigation extends AbstractInvestigation {
    private static final double CONVERTER = 9.43;
    private static UnitOfMeasurement[] validUnits = {UnitOfMeasurement.PGML, UnitOfMeasurement.PKMOLL};
    private static UnitOfMeasurement DEFAULT_UNIT = UnitOfMeasurement.PGML;

    public PTHInvestigation(final double value) throws InvalidUnitOfMeasureException {
        this(value, UnitOfMeasurement.PGML);
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
            case PGML:
                this.unitOfMeasurement = UnitOfMeasurement.PGML;
                break;
            case PKMOLL:
                this.unitOfMeasurement = UnitOfMeasurement.PKMOLL;
                currentConverter = 1 / CONVERTER;
                break;
            default:
                throw new InvalidUnitOfMeasureException(unitOfMeasurement);
        }
        this.setValue(this.getValue() * currentConverter);
        return this;
    }

    public PTHInvestigation changeUnitToDefault() throws InvalidUnitOfMeasureException {
        return this.changeUnitOfMeasurement(DEFAULT_UNIT);
    }

    public static double GetConverter() {
        return CONVERTER;
    }

}

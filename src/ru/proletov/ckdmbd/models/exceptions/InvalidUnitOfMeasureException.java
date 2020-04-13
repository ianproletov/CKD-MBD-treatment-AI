package ru.proletov.ckdmbd.models.exceptions;

import ru.proletov.ckdmbd.models.UnitOfMeasurement;

public class InvalidUnitOfMeasureException extends Exception {

    private UnitOfMeasurement unitOfMeasurement;
    private final String message = "Can not to proceed this unit of measure";

    public InvalidUnitOfMeasureException(final UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getMessage() {
        return (message + unitOfMeasurement);
    }
}

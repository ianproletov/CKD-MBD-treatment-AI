package ru.proletov.ckdmbd.models.exceptions;

import ru.proletov.ckdmbd.models.investigations.AbstractInvestigation;

public class InvalidUnitOfMeasureException extends Exception {

    private AbstractInvestigation.UnitOfMeasurement unitOfMeasurement;
    private final String message = "Can not to proceed this unit of measure";

    public InvalidUnitOfMeasureException(final AbstractInvestigation.UnitOfMeasurement unitOfMeasurement) {
        this.unitOfMeasurement = unitOfMeasurement;
    }

    public String getMessage() {
        return (message + unitOfMeasurement);
    }
}

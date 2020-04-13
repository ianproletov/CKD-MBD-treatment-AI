package ru.proletov.ckdmbd.models.exceptions;

public class InvalidUnitOfMeasureException extends Exception {
    public String getMessage() {
        return "Can not to proceed this unit of measure";
    }
}

package com.boot.quantitymeasurement.exception;

import com.boot.quantitymeasurement.enums.QuantityError;

public class QuantityException extends RuntimeException{
    private QuantityError error;

    public QuantityException(QuantityError error) {
        this.error = error;
    }

    public QuantityError getError() {
        return error;
    }

    public void setError(QuantityError error) {
        this.error = error;
    }
}

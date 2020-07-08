package com.boot.quantitymeasurement.enums;

public enum QuantityError {
    INVALID_MAIN_UNIT(400,"Enter proper main unit"), INVALID_SUB_UNIT(400,"Enter proper Sub Unit"), INVALID_UNIT(400,"Please Enter Valid Unit" ), INTERNAL_ERROR(500, "Try again later"), INVALID_QUANTITY(400, "Please Enter Valid Quantity");

    private int code;
    private String message;

    QuantityError(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

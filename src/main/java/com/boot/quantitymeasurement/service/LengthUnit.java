package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.QuantityError;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;

public class LengthUnit implements MainUnit{

    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        double intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    public double getInConvertedUnit(Unit.SubUnit unitTwo, double intoBaseUnit) {
        switch (unitTwo){
            case FEET:
                return intoBaseUnit/12;
            case CM:
                return (int) (intoBaseUnit*2.5);
            case YARD:
                return intoBaseUnit/36;
            case INCH:
                return intoBaseUnit;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }

    @Override
    public double getIntoBaseUnit(Unit.SubUnit unitOne, double sizeOne) {
        switch (unitOne){
            case FEET:
                return sizeOne*12;
            case CM:
                return (int) (sizeOne/2.5);
            case YARD:
                return sizeOne*36;
            case INCH:
                return sizeOne;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }
}

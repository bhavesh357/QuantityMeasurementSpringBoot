package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.QuantityError;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;

public class VolumeUnit implements MainUnit {
    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        double intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public double getInConvertedUnit(Unit.SubUnit unitTwo, double intoBaseUnit) {
        switch (unitTwo){
            case LITRE:
                return intoBaseUnit/1000;
            case GALLON:
                return intoBaseUnit/3785;
            case ML:
                return intoBaseUnit;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }

    @Override
    public double getIntoBaseUnit(Unit.SubUnit unitOne, double sizeOne) {
        switch (unitOne){
            case LITRE:
                return sizeOne*1000;
            case GALLON:
                return sizeOne*3785;
            case ML:
                return sizeOne;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }
}

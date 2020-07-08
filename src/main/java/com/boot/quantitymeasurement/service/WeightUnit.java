package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.QuantityError;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;


public class WeightUnit implements MainUnit {

    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        double intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public double getInConvertedUnit(Unit.SubUnit unitTwo, double intoBaseUnit) {
        switch (unitTwo){
            case KG:
                return intoBaseUnit/1000;
            case TON:
                return intoBaseUnit/1000000;
            case GRAM:
                return intoBaseUnit;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }

    public double getIntoBaseUnit(Unit.SubUnit unitOne, double sizeOne) {
        switch (unitOne){
            case KG:
                return sizeOne*1000;
            case TON:
                return sizeOne*1000000;
            case GRAM:
                return sizeOne;
            default:
                throw new QuantityException(QuantityError.INVALID_SUB_UNIT);
        }
    }
}

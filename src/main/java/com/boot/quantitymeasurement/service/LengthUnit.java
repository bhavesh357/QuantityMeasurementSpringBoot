package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public class LengthUnit implements MainUnit{

    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        int intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    public int getInConvertedUnit(Unit.SubUnit unitTwo, int intoBaseUnit) {
        switch (unitTwo){
            case FEET:
                return intoBaseUnit/12;
            case CM:
                return (int) (intoBaseUnit*2.5);
            case YARD:
                return intoBaseUnit/36;
            default:
                return intoBaseUnit;
        }
    }

    public int getIntoBaseUnit(Unit.SubUnit unitOne, int sizeOne) {
        switch (unitOne){
            case FEET:
                return sizeOne*12;
            case CM:
                return (int) (sizeOne/2.5);
            case YARD:
                return sizeOne*36;
            default:
                return sizeOne;
        }
    }
}

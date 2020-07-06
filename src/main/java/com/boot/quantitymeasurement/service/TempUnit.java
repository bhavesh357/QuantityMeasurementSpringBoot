package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public class TempUnit implements MainUnit {
    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        int intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public int getInConvertedUnit(Unit.SubUnit unitTwo, int intoBaseUnit) {
        switch (unitTwo) {
            case F:
                return ( (intoBaseUnit/5) * 9) +32;
            default:
                return intoBaseUnit;
        }
    }

    @Override
    public int getIntoBaseUnit(Unit.SubUnit unitOne, int sizeOne) {
        switch (unitOne) {
            case F:
                return ( (sizeOne-32) / 9) * 5;
            default:
                return sizeOne;
        }
    }
}

package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public class TempUnit implements MainUnit {
    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        double intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public double getInConvertedUnit(Unit.SubUnit unitTwo, double intoBaseUnit) {
        switch (unitTwo) {
            case F:
                return ( (intoBaseUnit/5) * 9) +32;
            default:
                return intoBaseUnit;
        }
    }

    @Override
    public double getIntoBaseUnit(Unit.SubUnit unitOne, double sizeOne) {
        switch (unitOne) {
            case F:
                return ( (sizeOne-32) / 9) * 5;
            default:
                return sizeOne;
        }
    }
}

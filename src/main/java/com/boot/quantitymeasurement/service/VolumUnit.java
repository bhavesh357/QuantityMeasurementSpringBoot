package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public class VolumUnit implements MainUnit {
    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        int intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public int getInConvertedUnit(Unit.SubUnit unitTwo, int intoBaseUnit) {
        switch (unitTwo){
            case LITRE:
                return intoBaseUnit/1000;
            case GALLON:
                return intoBaseUnit/3785;
            default:
                return intoBaseUnit;
        }
    }

    @Override
    public int getIntoBaseUnit(Unit.SubUnit unitOne, int sizeOne) {
        switch (unitOne){
            case LITRE:
                return sizeOne*1000;
            case GALLON:
                return sizeOne*3785;
            default:
                return sizeOne;
        }
    }
}

package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;


public class WeightUnit implements MainUnit {

    @Override
    public Quantity getConvertedQuantity(Quantity quantity) {
        int intoBaseUnit = getIntoBaseUnit(quantity.getUnitOne(), quantity.getSizeOne());
        quantity.setSizeTwo(getInConvertedUnit(quantity.getUnitTwo(),intoBaseUnit));
        return quantity;
    }

    @Override
    public int getInConvertedUnit(Unit.SubUnit unitTwo, int intoBaseUnit) {
        switch (unitTwo){
            case KG:
                return intoBaseUnit/1000;
            case TON:
                return intoBaseUnit/1000000;
            default:
                return intoBaseUnit;
        }
    }

    public int getIntoBaseUnit(Unit.SubUnit unitOne, int sizeOne) {
        switch (unitOne){
            case KG:
                return sizeOne*1000;
            case TON:
                return sizeOne*1000000;
            default:
                return sizeOne;
        }
    }
}

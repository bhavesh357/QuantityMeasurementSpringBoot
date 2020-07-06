package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public interface MainUnit {

    Quantity getConvertedQuantity(Quantity quantity);

    int getInConvertedUnit(Unit.SubUnit unitTwo, int intoBaseUnit);

    int getIntoBaseUnit(Unit.SubUnit unitOne, int sizeOne);
}

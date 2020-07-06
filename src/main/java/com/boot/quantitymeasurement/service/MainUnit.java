package com.boot.quantitymeasurement.service;

import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;

public interface MainUnit {

    Quantity getConvertedQuantity(Quantity quantity);

    double getInConvertedUnit(Unit.SubUnit unitTwo, double intoBaseUnit);

    double getIntoBaseUnit(Unit.SubUnit unitOne, double sizeOne);
}

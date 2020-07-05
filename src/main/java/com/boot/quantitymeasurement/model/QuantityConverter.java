package com.boot.quantitymeasurement.model;

import com.boot.quantitymeasurement.enums.Unit;

public class QuantityConverter {

    private Unit.MainUnit unit;

    private Unit.SubUnit unitOne;

    private int sizeOne;

    private Unit.SubUnit unitTwo;

    private int sizeTwo;

    public Unit.MainUnit getUnit() {
        return unit;
    }

    public void setUnit(Unit.MainUnit unit) {
        this.unit = unit;
    }

    public Unit.SubUnit getUnitOne() {
        return unitOne;
    }

    public void setUnitOne(Unit.SubUnit unitOne) {
        this.unitOne = unitOne;
    }

    public int getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(int sizeOne) {
        this.sizeOne = sizeOne;
    }

    public Unit.SubUnit getUnitTwo() {
        return unitTwo;
    }

    public void setUnitTwo(Unit.SubUnit unitTwo) {
        this.unitTwo = unitTwo;
    }

    public int getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(int sizeTwo) {
        this.sizeTwo = sizeTwo;
    }

}

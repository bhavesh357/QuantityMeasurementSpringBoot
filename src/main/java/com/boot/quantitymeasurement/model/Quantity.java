package com.boot.quantitymeasurement.model;

import com.boot.quantitymeasurement.enums.Unit;

public class Quantity {

    private Unit.MainUnit mainUnit;

    private Unit.SubUnit unitOne;

    private int sizeOne;

    private Unit.SubUnit unitTwo;

    private int sizeTwo;

    public Quantity(Unit.MainUnit mainUnit, Unit.SubUnit unitOne, int sizeOne, Unit.SubUnit unitTwo, int sizetwo) {
        this.mainUnit = mainUnit;
        this.unitOne = unitOne;
        this.sizeOne = sizeOne;
        this.unitTwo = unitTwo;
        this.sizeTwo = sizetwo;
    }

    public Unit.MainUnit getMainUnit() {
        return mainUnit;
    }

    public void setMainUnit(Unit.MainUnit mainUnit) {
        this.mainUnit = mainUnit;
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

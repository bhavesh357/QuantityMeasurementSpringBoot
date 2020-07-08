package com.boot.quantitymeasurement.model;

import com.boot.quantitymeasurement.enums.Unit;

import javax.validation.constraints.NotNull;

public class Quantity {

    @NotNull
    private Unit.MainUnit mainUnit;

    @NotNull
    private Unit.SubUnit unitOne;

    @NotNull
    private double sizeOne;

    @NotNull
    private Unit.SubUnit unitTwo;

    @NotNull
    private double sizeTwo;

    public Quantity(Unit.MainUnit mainUnit, Unit.SubUnit unitOne, double sizeOne, Unit.SubUnit unitTwo, double sizeTwo) {
        this.mainUnit = mainUnit;
        this.unitOne = unitOne;
        this.sizeOne = sizeOne;
        this.unitTwo = unitTwo;
        this.sizeTwo = sizeTwo;
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

    public double getSizeOne() {
        return sizeOne;
    }

    public void setSizeOne(double sizeOne) {
        this.sizeOne = sizeOne;
    }

    public Unit.SubUnit getUnitTwo() {
        return unitTwo;
    }

    public void setUnitTwo(Unit.SubUnit unitTwo) {
        this.unitTwo = unitTwo;
    }

    public double getSizeTwo() {
        return sizeTwo;
    }

    public void setSizeTwo(double sizeTwo) {
        this.sizeTwo = sizeTwo;
    }

}

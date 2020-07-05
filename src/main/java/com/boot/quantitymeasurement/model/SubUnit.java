package com.boot.quantitymeasurement.model;

import com.boot.quantitymeasurement.enums.Unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class SubUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private int parentId;

    private Unit.MainUnit unit;

    private Unit.SubUnit subUnit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    public Unit.MainUnit getUnit() {
        return unit;
    }

    public void setUnit(Unit.MainUnit unit) {
        this.unit = unit;
    }

    public Unit.SubUnit getSubUnit() {
        return subUnit;
    }

    public void setSubUnit(Unit.SubUnit subUnit) {
        this.subUnit = subUnit;
    }
}

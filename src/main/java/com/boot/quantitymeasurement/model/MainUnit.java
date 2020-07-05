package com.boot.quantitymeasurement.model;


import com.boot.quantitymeasurement.enums.Unit;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class MainUnit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private Unit.MainUnit unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Unit.MainUnit getUnit() {
        return unit;
    }

    public void setUnit(Unit.MainUnit unit) {
        this.unit = unit;
    }
}

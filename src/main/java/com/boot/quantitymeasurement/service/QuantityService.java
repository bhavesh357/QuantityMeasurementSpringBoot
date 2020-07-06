package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.model.Quantity;
import org.springframework.stereotype.Service;
import sun.security.util.Length;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class QuantityService {

    public MainUnit mainUnitConverter;

    public List<Unit.MainUnit> getMainUnit() {
        List<Unit.MainUnit> mainUnits = new ArrayList<>();
        Arrays.stream(Unit.MainUnit.values()).forEach(u -> mainUnits.add(u));
        return mainUnits;
    }

    public List<Unit.SubUnit> getSubUnit(Unit.MainUnit mainUnit) {
        ArrayList<Unit.SubUnit> subUnits = new ArrayList<>();
        Arrays.stream(Unit.SubUnit.values()).
                filter(u -> u.getMainUnit().equals(mainUnit)).
                    forEach(u -> subUnits.add(u));
        return subUnits;
    }

    public Quantity getConvertedQuantity(Quantity quantity) {
        switch (quantity.getMainUnit()){
            case LENGTH:
                mainUnitConverter= new LengthUnit();
                break;
            case WEIGHT:
                mainUnitConverter= new WeightUnit();
                break;
            case TEMP:
                mainUnitConverter = new TempUnit();
                break;
            default:
                mainUnitConverter = new VolumUnit();
        }
        return mainUnitConverter.getConvertedQuantity(quantity);
    }
}

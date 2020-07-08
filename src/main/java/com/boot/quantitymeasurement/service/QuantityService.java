package com.boot.quantitymeasurement.service;


import com.boot.quantitymeasurement.enums.QuantityError;
import com.boot.quantitymeasurement.enums.Unit;
import com.boot.quantitymeasurement.exception.QuantityException;
import com.boot.quantitymeasurement.model.Quantity;
import org.springframework.stereotype.Service;

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
            case VOLUME:
                mainUnitConverter = new VolumeUnit();
                break;
            default:
                throw new QuantityException(QuantityError.INVALID_MAIN_UNIT);
        }
        return mainUnitConverter.getConvertedQuantity(quantity);
    }
}
